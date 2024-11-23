package ru.otus.daggerhomework

import kotlinx.coroutines.flow.StateFlow

interface ColorsController {
    val colors: StateFlow<Int>
    fun updateColor(color: Int)
}

interface ColorsControllerProvider {
    fun provideColorsController(): ColorsController
}