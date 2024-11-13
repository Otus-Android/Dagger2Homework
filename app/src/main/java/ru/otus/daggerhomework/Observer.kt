package ru.otus.daggerhomework

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface Observer {
    fun sendEvent(color: Int)
    fun getEvents(): Channel<Int>
}

class ObserverImpl @Inject constructor() : Observer {

    private val event = Channel<Int>()

    override fun sendEvent(color: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            event.send(color)
        }
    }

    override fun getEvents(): Channel<Int> {
        return event
    }

}