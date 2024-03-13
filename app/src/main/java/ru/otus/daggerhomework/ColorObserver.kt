package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface ColorObserver {

    val currentColor: StateFlow<Int>
}

interface MutableColorObserver : ColorObserver {

    fun refreshColor()
}

class ColorObserverImpl @Inject constructor(
    private val colorGenerator: ColorGenerator
) : MutableColorObserver {

    private val _currentColor = MutableStateFlow(colorGenerator.generateColor())

    override val currentColor = _currentColor.asStateFlow()

    override fun refreshColor() {
        _currentColor.value = colorGenerator.generateColor()
    }
}