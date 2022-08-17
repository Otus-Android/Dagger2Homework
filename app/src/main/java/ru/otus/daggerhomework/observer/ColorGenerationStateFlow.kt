package ru.otus.daggerhomework.observer

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

interface ColorGenerationStateEmitter {
    suspend fun emit(state: ColorState)
}

interface ColorGenerationStateObserver {
    suspend fun receive(): StateFlow<ColorState>
}

@ActivityScope
class ColorGenerationStateFlow @Inject constructor(
) : ColorGenerationStateEmitter, ColorGenerationStateObserver {
    private val colorsStateFlow = MutableStateFlow<ColorState>(ColorState.Default)

    override suspend fun emit(state: ColorState) {
        colorsStateFlow.emit(state)
    }

    override suspend fun receive() = colorsStateFlow as StateFlow<ColorState>
}

sealed class ColorState {

    object Default : ColorState()

    data class Color(@ColorInt val color: Int) : ColorState()
}