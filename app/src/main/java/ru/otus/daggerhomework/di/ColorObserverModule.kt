package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
object ColorObserverModule {

    @ActivityScope
    @Provides
    fun provideMutableObserver(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }

    @ActivityScope
    @Provides
    fun provideImmutableObserver(flow: MutableStateFlow<Int?>): StateFlow<Int?> {
        return flow
    }
}