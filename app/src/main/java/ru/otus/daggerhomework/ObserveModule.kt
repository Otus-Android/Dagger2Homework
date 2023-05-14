package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
object ObserveModule {

    @ActivityScope
    @Provides
    fun stateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int?> {
        return mutableStateFlow
    }

    @ActivityScope
    @Provides
    fun mutableStateFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }
}