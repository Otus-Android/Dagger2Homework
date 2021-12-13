package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
object MainActivityModule {

    @ActivityScope
    @Provides
    fun colorState(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}