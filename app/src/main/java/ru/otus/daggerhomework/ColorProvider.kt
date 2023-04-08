package ru.otus.daggerhomework

import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ColorProvider @Inject constructor(): ColorReceiver, ColorProducer {
    private val _color = MutableSharedFlow<Int>()
    override val color: SharedFlow<Int> = _color

    override suspend fun receiveColor(color: Int) {
        _color.emit(color)
    }
}