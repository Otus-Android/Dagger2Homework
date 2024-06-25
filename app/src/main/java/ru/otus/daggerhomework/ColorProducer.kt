package ru.otus.daggerhomework

import javax.inject.Inject

class ColorProducer @Inject constructor(
    private val colorEventSource : ColorEventSource,
) {
    fun sendColor(color: Int) { colorEventSource.events.tryEmit(color) }
}