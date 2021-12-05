package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

// TODO: Надо бы разделить отдельно на прием и отправку событий, но как сделать два binds на один instance класса?
interface EventBus {
    val events: Flow<Int>

    fun dispatch(value: Int)
}

class EventBusImpl @Inject constructor() : EventBus {

    private val channel = Channel<Int>(Channel.BUFFERED)
    override val events = channel.receiveAsFlow()

    override fun dispatch(value: Int) {
        channel.trySend(value)
    }
}