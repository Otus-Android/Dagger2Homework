package ru.otus.daggerhomework.repository

import kotlinx.coroutines.flow.StateFlow

interface ColorRepository {
    fun updateColor(color: Int)

    fun getColorFlow() : StateFlow<Int>
}