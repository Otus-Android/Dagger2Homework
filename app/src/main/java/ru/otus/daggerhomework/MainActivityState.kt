package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityState(color: Int = Color.BLACK) : ColorsController {
    private val _colors = MutableStateFlow(color)
    override val colors: StateFlow<Int>
        get() = _colors

    override fun updateColor(color: Int) {
        CoroutineScope(Dispatchers.Main.immediate).launch {
            _colors.emit(color)
        }
    }
}