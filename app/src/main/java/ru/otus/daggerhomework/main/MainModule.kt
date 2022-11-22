package ru.otus.daggerhomework.main

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
object MainModule {
    @Singleton
    @Provides
    fun provideStateFlow(): MutableStateFlow<Int> = MutableStateFlow(0)
}
