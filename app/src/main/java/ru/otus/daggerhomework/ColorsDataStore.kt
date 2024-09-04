package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject


class ColorsDataStore @Inject constructor() {
    private val _colorFlow = MutableSharedFlow<Int>()
    val colorFlow = _colorFlow.asSharedFlow()

    suspend fun sent(color: Int) {
        _colorFlow.emit(color)
    }
}