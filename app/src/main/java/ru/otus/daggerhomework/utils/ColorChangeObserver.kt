package ru.otus.daggerhomework.utils

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

interface ColorChangeObserver {
    val changeEvent: SharedFlow<Int>
    suspend fun changeColor(color: Int)
}

class ColorChangeObserverImpl @Inject constructor() : ColorChangeObserver {
    private val _changeEvent = MutableSharedFlow<Int>()
    override val changeEvent: SharedFlow<Int> = _changeEvent.asSharedFlow()

    override suspend fun changeColor(color: Int) {
        _changeEvent.emit(color)
    }
}