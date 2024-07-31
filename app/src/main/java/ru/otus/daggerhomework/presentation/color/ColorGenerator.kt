package ru.otus.daggerhomework.presentation.color

import androidx.annotation.ColorInt

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}