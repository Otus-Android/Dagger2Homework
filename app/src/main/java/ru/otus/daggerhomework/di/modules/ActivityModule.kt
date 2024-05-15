package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.annotations.MainActivityScope
import ru.otus.daggerhomework.di.annotations.StateFlowColor
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl

@Module
interface ActivityModule {

    companion object {
        @Provides
        @StateFlowColor
        @MainActivityScope
        fun provideMutableStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }

    @Binds
    @StateFlowColor
    fun provideStateFlow(@StateFlowColor mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>

    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}