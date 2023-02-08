package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class EventBus {

    private val _events = Channel<Int>()
    val events = _events.receiveAsFlow()

    suspend fun postEvent(color: Int) {
        _events.send(color)
    }

    override fun toString(): String {
        return "EventBus(_events=$_events, events=$events)"
    }


}