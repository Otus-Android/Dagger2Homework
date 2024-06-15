package ru.otus.daggerhomework

import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ColorReceiver @Inject constructor(
    private val colorEventSource: ColorEventSource
) {
    fun listenColorEvents(): StateFlow<Int?> {
        return colorEventSource.events.asStateFlow()
    }
}
