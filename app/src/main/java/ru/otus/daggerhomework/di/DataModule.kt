package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.*
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.State
import ru.otus.daggerhomework.di.scopes.ActivityScope

@Module
interface DataModule {
    @Binds
    @ActivityScope
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    companion object {
        @Provides
        @ActivityScope
        fun provideColorFlowMutable(): MutableSharedFlow<State> {
            return MutableSharedFlow()
        }
    }
}