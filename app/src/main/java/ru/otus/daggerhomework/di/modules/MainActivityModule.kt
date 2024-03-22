package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
interface MainActivityModule {

    companion object {
        @Provides
        @Reusable
        @JvmStatic
        fun provideStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun provideStateColor(stateColor: MutableStateFlow<Int>): StateFlow<Int>

}