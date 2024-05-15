package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.IO
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    @IO private val ioDispatcher: CoroutineDispatcher,
    private val eventObserver: EventObserver,
) {
    private val _colorFlow = MutableStateFlow<Int?>(null)
    val colorFlow: StateFlow<Int?> get() = _colorFlow


    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        CoroutineScope(ioDispatcher).launch {
            eventObserver.events.collect { event ->
                if (event is Event.ColorEvent) {
                    _colorFlow.value = event.color
                    Log.d("ViewModelReceiver", "Color received: ${event.color}")
                }
            }
        }
    }
}