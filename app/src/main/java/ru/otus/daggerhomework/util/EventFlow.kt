package ru.otus.daggerhomework.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class EventFlow @Inject constructor() {

    private val _events = MutableSharedFlow<Event>()

    suspend fun send(event: Event) {
        _events.emit(event)
    }

    fun events(): Flow<Event> {
        return _events.asSharedFlow()
    }
}


