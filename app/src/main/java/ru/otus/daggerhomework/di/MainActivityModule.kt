package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module(includes = [MainActivityModule.Bindings::class])
object MainActivityModule {

    @Provides
    @PerActivity
    fun provideObserver(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }

    @Module
    interface Bindings {
        @Binds
        fun bindsColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
    }
}