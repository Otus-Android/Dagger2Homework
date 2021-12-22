package ru.otus.daggerhomework

import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class Transceiver @Inject constructor() {

    private val channel = Channel<Int>()

    suspend fun send(value: Int) {
        channel.send(value)
    }

    suspend fun receive(): Int {
        return channel.receive()
    }
}