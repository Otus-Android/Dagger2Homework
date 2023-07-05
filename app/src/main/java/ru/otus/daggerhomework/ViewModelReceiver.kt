package ru.otus.daggerhomework

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val eventBus: EventBus,
    private val context: Application
) {

    private val scope = MainScope()
    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int>
        get() = _color

    fun observeColors() {

        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        scope.launch {
            eventBus.events.collect {
                _color.value = it
                Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
            }
        }

    }

}

class ViewModelReceiverFactory @Inject constructor(private val eventBus: EventBus,
                                                   private val context: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelReceiver(eventBus, context) as T
    }
}