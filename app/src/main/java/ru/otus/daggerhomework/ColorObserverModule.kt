package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Module
interface ColorObserverModule {

    companion object {
        @ActivityColorScope
        @Provides
        fun provideMutableStateFlow(): MutableStateFlow<Int> = MutableStateFlow(0)

        @ActivityColorScope
        @Provides
        fun provideStateFlow(flow: MutableStateFlow<Int>): StateFlow<Int> = flow.asStateFlow()
    }


}