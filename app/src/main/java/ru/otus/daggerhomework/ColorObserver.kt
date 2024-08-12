package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.annotations.ActivityScope
import javax.inject.Inject

@ActivityScope
class ColorObserver @Inject constructor() {

    private val _colorFlow = MutableStateFlow(0)
    val colorFlow = _colorFlow.asStateFlow()

    fun sendColor(@ColorInt colorInt: Int) {
        _colorFlow.value = colorInt
    }
}