package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Module
object FlowModule {

    @Provides
    @ActivityScope
    fun provideMutableFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }

    @Provides
    @ActivityScope
    fun provideFlow(mutableStateFlow: MutableStateFlow<Int?>): StateFlow<Int?> {
        return mutableStateFlow.asStateFlow()
    }

}
