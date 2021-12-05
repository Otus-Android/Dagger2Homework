package ru.otus.daggerhomework.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.EventBus
import ru.otus.daggerhomework.di.ActivityContext

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val producer: EventBus,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
        producer.dispatch(colorGenerator.generateColor())
    }

    class Factory(
        private val colorGenerator: ColorGenerator,
        private val producer: EventBus,
        private val context: Context
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == ViewModelProducer::class.java) {
                return ViewModelProducer(colorGenerator, producer, context) as T
            }

            throw IllegalStateException("Unknown class ${modelClass.name}")
        }
    }

}