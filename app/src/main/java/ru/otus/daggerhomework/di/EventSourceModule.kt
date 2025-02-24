package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.Event

@Module
object EventSourceModule {

    @ActivityScope
    @Provides
    fun getEventSource() = MutableSharedFlow<Event>()
}