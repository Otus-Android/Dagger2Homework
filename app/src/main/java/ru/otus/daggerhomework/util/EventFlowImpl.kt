package ru.otus.daggerhomework.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class EventFlowImpl @Inject constructor() : EventFlow, EventSender {

    private val _events = MutableSharedFlow<Event>()

    override suspend fun send(event: Event) {
        _events.emit(event)
    }

    override fun events(): Flow<Event> {
        return _events.asSharedFlow()
    }
}


