package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
class MainActivityModule {
    @ActivityScope
    @ColorState
    @Provides
    fun provideColorStateFlow(): StateFlow<Int?> {
        return MutableStateFlow(null)
    }
}