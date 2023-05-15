package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.AppEvent
import javax.inject.Singleton

@Module
object EventModule {
    @Singleton
    @Provides
    fun provideMutableEventFlow() = MutableSharedFlow<AppEvent>(0, 1, BufferOverflow.DROP_OLDEST)

    @Provides
    fun provideEventFlow(eventFlow: MutableSharedFlow<AppEvent>) = eventFlow.asSharedFlow()
}