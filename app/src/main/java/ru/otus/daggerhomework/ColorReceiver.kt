package ru.otus.daggerhomework

import javax.inject.Inject
import kotlinx.coroutines.flow.asSharedFlow

class ColorReceiver @Inject constructor(
    private val colorEventSource : ColorEventSource,
) {

    fun listenColorEvent() = colorEventSource.events.asSharedFlow()
}