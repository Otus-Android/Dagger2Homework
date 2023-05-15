package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.otus.daggerhomework.AppEvent
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Singleton

/**
 * Модуль подключен в ApplicationComponent, так как используется Jetpack ViewModel [ViewModelReceiver]
 * которая живет дольше, MainActivity и MainActivityComponent
 */
@Module
object EventModule {
    @Singleton
    @Provides
    fun provideMutableEventFlow() = MutableSharedFlow<AppEvent>(0, 1, BufferOverflow.DROP_OLDEST)

    @Provides
    fun provideEventFlow(eventFlow: MutableSharedFlow<AppEvent>) = eventFlow.asSharedFlow()
}