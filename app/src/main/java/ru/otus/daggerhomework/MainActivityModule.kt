package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Module
interface MainActivityModule {

    companion object {
        @Provides
        @ActivityScope
        fun provideMutableStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }

        @Provides
        @ActivityScope
        fun provideStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int> {
            return mutableStateFlow.asStateFlow()
        }
    }
}