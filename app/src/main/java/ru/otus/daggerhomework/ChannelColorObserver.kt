package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class ChannelColorObserver @Inject constructor() : ColorObserver {

    private val channel = Channel<Int>()

    override suspend fun send(color: Int) {
        channel.send(color)
    }

    override suspend fun receive(): Int {
        return channel.receive()
    }
}