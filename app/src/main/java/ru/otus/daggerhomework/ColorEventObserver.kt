package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ColorEventObserver {

    private val _colorEventState: MutableStateFlow<Int> = MutableStateFlow(Color.YELLOW)
    val colorEventState = _colorEventState.asStateFlow()

    fun setColor(color: Int) {
        _colorEventState.value = color
    }
}