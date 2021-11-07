package ru.otus.daggerhomework

import androidx.annotation.ColorInt

interface ColorObserver {

    suspend fun send(@ColorInt color: Int)

    suspend fun receive(): Int
}