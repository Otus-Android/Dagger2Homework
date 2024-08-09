package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ColorEventObserver @Inject constructor() {

    private val _colorEventState: MutableStateFlow<Int> = MutableStateFlow(Color.YELLOW)
    private val colorEventState = _colorEventState.asStateFlow()

    fun setColor(color: Int) {
        _colorEventState.value = color
    }

    suspend fun onChangeColorState(onChange: (Int) -> Unit) {
        colorEventState.collect {
            onChange.invoke(it)
        }
    }
}