package ru.otus.daggerhomework.feature.providers

import kotlinx.coroutines.flow.MutableStateFlow

interface ColorUpdateProvider {
    fun provideMutableStateColor(): MutableStateFlow<Int?>
}