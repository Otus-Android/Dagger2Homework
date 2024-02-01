package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

interface EventBus {

    val events: Flow<Int?>

    suspend fun publishEvent(event: Int)
}

class EventBusImpl @Inject constructor() : EventBus {

    private val _events = MutableStateFlow<Int?>(null)

    override val events: Flow<Int?> = _events.asSharedFlow()

    override suspend fun publishEvent(event: Int) {
        _events.tryEmit(event)
    }
}