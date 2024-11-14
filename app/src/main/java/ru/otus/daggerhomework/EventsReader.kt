package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow

interface EventsReader {
    val eventsFlow: Flow<Int>
}