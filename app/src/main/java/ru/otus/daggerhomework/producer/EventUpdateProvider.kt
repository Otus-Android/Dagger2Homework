package ru.otus.daggerhomework.producer

import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.activity.Event

interface EventUpdateProvider {
    fun provideMutableStateEvent(): MutableStateFlow<Event?>
}