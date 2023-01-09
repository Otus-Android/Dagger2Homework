package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val colorStateFlow: StateFlow<Int>
) {
    private val coroutineScope: CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    private val _colorState: MutableStateFlow<Int> = MutableStateFlow(0)
    val colorState: StateFlow<Int> = _colorState

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        coroutineScope.launch {
            colorStateFlow.collect { color ->
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                _colorState.value = color
            }
        }
    }
}
