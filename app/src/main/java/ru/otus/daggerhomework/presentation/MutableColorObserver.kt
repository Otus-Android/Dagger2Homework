package ru.otus.daggerhomework.presentation

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class MutableColorObserver @Inject constructor() : ReadOnlyColorObserver {

    private val _mutableColorFlow = MutableStateFlow(0)
    override val colorFlow = _mutableColorFlow.asStateFlow()

    fun setColor(@ColorInt color: Int) {
        _mutableColorFlow.value = color
    }
}