package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface ColorObserver {

    fun getColorFlow(): StateFlow<Int>
    fun updateColor(@ColorInt color: Int)

}

class ColorObserverImpl @Inject constructor() : ColorObserver {

    private val _colorFlow = MutableStateFlow(0)

    override fun getColorFlow(): StateFlow<Int> {
        return _colorFlow.asStateFlow()
    }

    override fun updateColor(color: Int) {
        _colorFlow.value = color
    }
}