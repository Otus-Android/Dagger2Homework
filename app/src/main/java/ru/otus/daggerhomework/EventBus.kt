package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

interface EventBusReceiver {
    val events: Flow<Int>
}

interface EventBusProducer {
    fun dispatch(value: Int)
}

@ActivityScope
class EventBusImpl @Inject constructor() : EventBusReceiver, EventBusProducer {

    private val channel = Channel<Int>(Channel.BUFFERED)
    override val events = channel.receiveAsFlow()

    override fun dispatch(value: Int) {
        channel.trySend(value)
    }
}