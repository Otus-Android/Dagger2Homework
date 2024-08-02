package ru.otus.daggerhomework

import androidx.annotation.ColorInt

sealed interface GeneratedColor {
    data class Success(@ColorInt val colorInt: Int) : GeneratedColor
    object Default : GeneratedColor
}