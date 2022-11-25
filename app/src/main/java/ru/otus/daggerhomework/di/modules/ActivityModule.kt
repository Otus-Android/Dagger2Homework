package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.scopes.MainActivityScope
import ru.otus.daggerhomework.di.qualifiers.Immutable

@Module
interface ActivityModule {

    companion object {

        @Provides
        @MainActivityScope
        fun provideMutableStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow<Int>(0)
        }
    }

    @Binds
    @Immutable
    fun provideStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>

    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}