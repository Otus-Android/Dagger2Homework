package ru.otus.daggerhomework

import dagger.*
import kotlinx.coroutines.flow.*

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