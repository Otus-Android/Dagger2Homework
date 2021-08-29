package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow

@Module
object MainActivityModule {

    @JvmStatic
    @Provides
    @ActivityScope
    fun provideEventChannel(): MutableSharedFlow<Int> {
        return MutableSharedFlow()
    }
}