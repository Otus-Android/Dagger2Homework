package ru.otus.daggerhomework

import kotlinx.coroutines.flow.SharedFlow

interface EventObservable {
    val events: SharedFlow<Event>
}