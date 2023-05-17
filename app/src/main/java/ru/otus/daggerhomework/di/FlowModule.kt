package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
object FlowModule {

    @Provides
    @ActivityScope
    fun provideFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }

}
