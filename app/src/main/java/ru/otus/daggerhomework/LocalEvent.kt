package ru.otus.daggerhomework

import androidx.annotation.ColorInt

sealed interface LocalEvent {
    data class ColorData(
        @ColorInt val color: Int
    ): LocalEvent
    data class Error(
        val e: Exception
    ): LocalEvent
}
