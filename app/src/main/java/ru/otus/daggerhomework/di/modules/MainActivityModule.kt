package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.annotations.MainActivityScope

@Module
interface MainActivityModule {

    companion object {
        @Provides
        @MainActivityScope
        fun provideStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun provideStateColor(stateColor: MutableStateFlow<Int>): StateFlow<Int>

}