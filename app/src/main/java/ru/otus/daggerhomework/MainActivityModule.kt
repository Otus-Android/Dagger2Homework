package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Module
object MainActivityModule {

    @Provides
    @ActivityScope
    fun provideMutableColorStateFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }

    @Provides
    @ActivityScope
    fun provideColorStateFlow(
        mutableStateFlow: MutableStateFlow<Int?>
    ): StateFlow<Int?> {
        return mutableStateFlow.asStateFlow()
    }
}