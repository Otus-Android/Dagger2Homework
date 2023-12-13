package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class ColorObserverImpl @Inject constructor() : ColorObserver {

    private val _event = MutableSharedFlow<Int>()
    override val event: SharedFlow<Int> = _event.asSharedFlow()

    override suspend fun observeColor(color: Int) {
        _event.emit(color)
    }
}
