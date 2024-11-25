package com.mironchik.multimodule.base.colors

import androidx.annotation.ColorInt

interface ColorsGenerator {
    @ColorInt
    fun generateColor(): Int
}

