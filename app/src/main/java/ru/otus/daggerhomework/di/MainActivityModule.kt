package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Module
interface MainActivityModule {

    @Binds
    fun bindFlow(flow: MutableStateFlow<Int>): Flow<Int>

    companion object {
        @MainActivityScope
        @Provides
        fun mutableStateFlow(): MutableStateFlow<Int> = MutableStateFlow(0)
    }
}