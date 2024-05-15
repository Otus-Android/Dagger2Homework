package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class EventObserver @Inject constructor() {
    private val _events = MutableStateFlow<Event?>(null)
    val events: StateFlow<Event?> get() = _events

    fun sendEvent(event: Event) {
        _events.value = event
    }
}

sealed class Event {
    data class ColorEvent(val color: Int) : Event()
}
