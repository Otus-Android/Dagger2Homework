package ru.otus.daggerhomework.presentation

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class ColorObserver @Inject constructor() {

    private val _mutableColorFlow = MutableStateFlow(0)
    val colorFlow = _mutableColorFlow.asStateFlow()

    fun setColor(@ColorInt color: Int) {
        _mutableColorFlow.value = color
    }
}