package ru.otus.daggerhomework

import androidx.annotation.ColorInt

sealed class ColorState {
    
    object Init : ColorState()
    
    data class Color(@ColorInt val color: Int) : ColorState()
    
}