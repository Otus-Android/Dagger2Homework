package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@MainActivityScope
class EventsState @Inject constructor(){
    val events: MutableStateFlow<Int?> = MutableStateFlow(null)
}

interface EventsObserver {
    fun getEvents(): StateFlow<Int?>
}

class EventsObserverImpl @Inject constructor(
    private val state: EventsState
) : EventsObserver {
    override fun getEvents(): StateFlow<Int?> = state.events
}

interface EventsProducer {
    suspend fun emit(color: Int)
}

class EventsProducerImpl @Inject constructor(
    private val state: EventsState
) : EventsProducer {
    override suspend fun emit(color: Int) {
        state.events.emit(color)
    }
}