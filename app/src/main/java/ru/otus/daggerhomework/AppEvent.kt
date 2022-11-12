package ru.otus.daggerhomework

import androidx.annotation.ColorInt

sealed class AppEvent {
    data class ChangeColor(@ColorInt val colorRgba: Int) : AppEvent()
}