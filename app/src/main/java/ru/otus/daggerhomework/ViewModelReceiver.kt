package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val eventBus: EventBus,
) {
    val color: Flow<Int?>
        get() = _color.asStateFlow()

    private val _color: MutableStateFlow<Int?> = MutableStateFlow(null)
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        scope.launch {
            eventBus.events.collect { event ->
                if (event == null) return@collect
                _color.tryEmit(event)
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun clear() {
        scope.coroutineContext.cancel()
    }
}