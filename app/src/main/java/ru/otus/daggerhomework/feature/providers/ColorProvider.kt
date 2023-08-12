package ru.otus.daggerhomework.feature.providers

import kotlinx.coroutines.flow.StateFlow

interface ColorProvider {
    fun provideStateFlowColor(): StateFlow<Int?>
}