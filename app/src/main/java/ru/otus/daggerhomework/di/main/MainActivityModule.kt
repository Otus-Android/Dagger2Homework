package ru.otus.daggerhomework.di.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.presentation.color.ColorGenerator
import ru.otus.daggerhomework.presentation.color.ColorGeneratorImpl
import ru.otus.daggerhomework.di.utils.scopes.ActivityScope

@Module
interface MainActivityModule {
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    companion object {
        @ActivityScope
        @Provides
        fun provideChannel(): Channel<Int> = Channel(Channel.CONFLATED)
    }
}