package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class ColorObserverImpl @Inject constructor() : ColorObserver {

    private val channel = Channel<Int>()

    override suspend fun send(color: Int) {
        channel.send(color)
    }

    override suspend fun receive(): Int {
        return channel.receive()
    }
}
