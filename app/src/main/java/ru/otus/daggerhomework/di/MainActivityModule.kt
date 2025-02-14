package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.Event

@Module
class MainActivityModule {
    @Provides
    @ActivityScope
    fun events(): MutableStateFlow<Event?> = MutableStateFlow(null)
}