package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.otus.daggerhomework.AppEvent
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Singleton

@Module
interface EventModule {
    companion object {
        @ActivityScope
        @Provides
        fun provideMutableEventFlow() = MutableSharedFlow<AppEvent>(0, 1, BufferOverflow.DROP_OLDEST)
    }

    @Binds
    fun bindEventFlow(impl: MutableSharedFlow<AppEvent>): SharedFlow<AppEvent>
}