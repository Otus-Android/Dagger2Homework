package ru.otus.daggerhomework.receiver

import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.activity.Event

interface EventProvider {
    fun provideStateFlowEvent(): StateFlow<Event>
}