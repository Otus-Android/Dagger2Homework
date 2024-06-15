package ru.otus.daggerhomework

import javax.inject.Inject

class ColorProducer @Inject constructor(
    private val colorEventSource: ColorEventSource
) {
    fun sentNewColor(color: Int) {
        colorEventSource.events.tryEmit(color)
    }
}
