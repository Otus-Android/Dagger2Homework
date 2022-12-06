package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
interface ActivityModule {

    companion object {

        @Provides
        @ActivityScope
        fun provideMutableStateFlow() = MutableStateFlow(0)
    }

    @Binds
    fun provideStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>

    @Binds
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}