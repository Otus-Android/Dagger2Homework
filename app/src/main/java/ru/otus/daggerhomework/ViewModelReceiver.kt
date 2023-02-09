package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ViewModelReceiver (
    val eventBus: EventBus,
    private val context: Context
): ViewModel() {

    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int>
        get() = _color

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            eventBus.events.collect {
                _color.value = it
            }
        }
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}

class ViewModelReceiverFactory(private val eventBus: EventBus,
                               private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelReceiver(eventBus, context) as T
    }
}