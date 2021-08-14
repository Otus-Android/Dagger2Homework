package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.scope.ActivityScope

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideSharedFlow(): SharedFlow<Int> {
        return MutableSharedFlow()
    }

    @ActivityScope
    @Provides
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}