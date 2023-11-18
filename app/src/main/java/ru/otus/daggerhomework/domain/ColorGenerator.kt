package ru.otus.daggerhomework.domain

import androidx.annotation.ColorInt

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}