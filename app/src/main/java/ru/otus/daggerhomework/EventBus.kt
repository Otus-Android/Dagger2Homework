package ru.otus.daggerhomework

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface EventBus {
    val events: StateFlow<Int>
    suspend fun send(value: Int)
}

@ActivityScope
class EventBusImpl @Inject constructor() : EventBus {

    private val _events = MutableStateFlow<Int>(0)
    override val events: StateFlow<Int> = _events.asStateFlow()

    override suspend fun send(value: Int) {
        Log.d("BUS", "emit $value")
        _events.emit(value)
    }
}