package ru.otus.daggerhomework.activity

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
interface ActivityModule {

    companion object {
        @ActivityScope
        @Provides
        fun provideSource(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }
}