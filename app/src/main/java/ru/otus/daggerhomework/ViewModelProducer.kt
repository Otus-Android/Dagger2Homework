package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @Named("ActivityContext") private val context: Context,
    private val mediator: Mediator
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        mediator.sendEvent(colorGenerator.generateColor())
    }

    class ViewModelProducerFactory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @Named("ActivityContext") private val context: Context,
        private val mediator: Mediator
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelProducer(colorGenerator, context, mediator) as T
        }
    }
}