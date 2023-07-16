package ru.otus.daggerhomework.utils

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

interface Notification {

    val events: Flow<Int>

    suspend fun sendEvent(event: Int)
}

class NotificationImpl @Inject constructor() : Notification {

    private val channel = Channel<Int>()
    override val events: Flow<Int> = channel.receiveAsFlow()

    override suspend fun sendEvent(event: Int) {
        channel.send(event)
    }
}
