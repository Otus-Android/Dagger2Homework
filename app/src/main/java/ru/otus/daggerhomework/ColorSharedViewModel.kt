package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@ActivityScope
class ColorSharedViewModel @Inject constructor() {
    private val colorFlow = MutableStateFlow<Int?>(null)

    fun getColor(): SharedFlow<Int?> {
        return colorFlow.asStateFlow()
    }

    fun setColor(@ColorInt color: Int?) {
        colorFlow.value = color
    }
}