package ru.otus.daggerhomework.di.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.di.application.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val colorState: ColorState,
    @ApplicationContext private val context: Context,
) {

    private val _state: MutableStateFlow<Int> = MutableStateFlow(0)
    val state: StateFlow<Int> = _state.asStateFlow()

    init {
        observeColors()
    }

    private fun observeColors() = CoroutineScope(Dispatchers.Main).launch {
        colorState.state.onEach {
            _state.value = it
        }.launchIn(this)
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}