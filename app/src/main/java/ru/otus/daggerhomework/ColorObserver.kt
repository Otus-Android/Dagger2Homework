package ru.otus.daggerhomework

import kotlinx.coroutines.flow.SharedFlow

interface ColorObserver {

    val event: SharedFlow<Int>

    suspend fun observeColor(color: Int)
}
