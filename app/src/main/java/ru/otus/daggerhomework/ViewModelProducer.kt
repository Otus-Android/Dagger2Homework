package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelProducer(
    private val eventBus: EventBus,
    private val colorGenerator: ColorGenerator,
    private val context: Context
):ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            eventBus.postEvent(colorGenerator.generateColor())
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory(private val eventBus: EventBus,
                               private val colorGenerator: ColorGenerator,
                               private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelProducer(eventBus, colorGenerator, context) as T //super.create(modelClass)
    }
}