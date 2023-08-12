package ru.otus.daggerhomework.feature.models

import androidx.annotation.ColorInt

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}