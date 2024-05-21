package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

interface ColorObserver {
    val currentColor: SharedFlow<Int>

    suspend fun changeColor(color: Int)
}

class ColorObserverImpl @Inject constructor() : ColorObserver {

    private val _currentColor = MutableSharedFlow<Int>()
    override val currentColor = _currentColor.asSharedFlow()

    override suspend fun changeColor(color: Int) {
        _currentColor.emit(color)
    }
}