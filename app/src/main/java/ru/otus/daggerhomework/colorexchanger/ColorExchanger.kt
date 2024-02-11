package ru.otus.daggerhomework.colorexchanger

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ColorExchanger {
    fun updateColor(@ColorInt color: Int)

    fun getColorFlow(): Flow<Int?>
}