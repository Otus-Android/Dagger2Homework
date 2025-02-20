package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.ColorStateImpl
import ru.otus.daggerhomework.di.scope.ActivityScope

@Module

object MainActivityModule {
    @Provides
    @ActivityScope
        fun provideColorState(): ColorState = ColorStateImpl()

}