package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@ActivityScope
class EventBus @Inject constructor() {

    private val _events = Channel<Int>()
    val events = _events.receiveAsFlow()

    suspend fun postEvent(color: Int) {
        _events.send(color)
    }

}