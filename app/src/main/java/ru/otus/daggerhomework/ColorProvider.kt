package ru.otus.daggerhomework

import kotlinx.coroutines.flow.*
import javax.inject.Inject

interface ColorProvider {
    val colorState: Flow<Int>
    suspend fun sendColor(color: Int)
}

class ColorProviderImpl @Inject constructor(): ColorProvider {
    private val _colorState = MutableSharedFlow<Int>()
    override val colorState: SharedFlow<Int> = _colorState

    override suspend fun sendColor(color: Int) {
        _colorState.emit(color)
    }
}