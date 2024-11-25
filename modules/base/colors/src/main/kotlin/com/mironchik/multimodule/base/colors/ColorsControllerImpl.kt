package com.mironchik.multimodule.base.colors

import android.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ColorsControllerImpl(color: Int = Color.BLACK) : ColorsController {
    private val _color: MutableStateFlow<Int> = MutableStateFlow(color)
    override val color: StateFlow<Int>
        get() = _color

    override fun updateColor(color: Int) {
        CoroutineScope(Dispatchers.Main.immediate).launch {
            _color.emit(color)
        }
    }
}