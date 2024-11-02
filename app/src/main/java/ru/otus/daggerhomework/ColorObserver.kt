package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


interface ImmutableColorObserver {

    val colorFlow: StateFlow<Int>
}

interface ColorObserver : ImmutableColorObserver {
    fun sendColor(@ColorInt colorInt: Int)
}

@ActivityScope
class ColorObserverImpl @Inject constructor() : ColorObserver {
    private val _colorFlow = MutableStateFlow(0)
    override val colorFlow = _colorFlow.asStateFlow()

    override fun sendColor(@ColorInt colorInt: Int) {
        _colorFlow.value = colorInt
    }
}