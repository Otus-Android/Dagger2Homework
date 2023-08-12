package ru.otus.daggerhomework.activity

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Event

@Module
object MainActivityModule {

    @Provides
    fun provideMutableStateEvent(): MutableStateFlow<Event?> =
        MutableStateFlow(null)

    @Provides
    fun updateEvent(event: MutableStateFlow<Event>): StateFlow<Event> =
        event.asStateFlow()
}
