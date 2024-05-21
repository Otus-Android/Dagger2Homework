package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface EventObserver {
    suspend fun sendEvent(color: Int)
    fun getEvents(): StateFlow<Int?>
}

class EventObserverImpl @Inject constructor() : EventObserver {
    private val events: MutableStateFlow<Int?> = MutableStateFlow(null)
    override suspend fun sendEvent(color: Int) {
        events.value = color
    }

    override fun getEvents(): StateFlow<Int?> = events
}