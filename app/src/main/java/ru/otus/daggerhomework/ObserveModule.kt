package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
object ObserveModule {

    @ActivityScope
    @Provides
    fun stateFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }
}