package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class EventsWriterReader @Inject constructor() : EventsReader, EventsWriter {
    private val _eventsFlow = MutableSharedFlow<Int>(replay = 1)

    override val eventsFlow: Flow<Int>
        get() = _eventsFlow.asSharedFlow()

    override fun writeEvent(color: Int) {
        _eventsFlow.tryEmit(color)
    }
}