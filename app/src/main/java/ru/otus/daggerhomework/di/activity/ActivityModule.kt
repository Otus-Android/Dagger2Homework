package ru.otus.daggerhomework.di.activity

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.ColorStateImpl
import ru.otus.daggerhomework.di.application.ActivityScope

@Module
interface ActivityModule {

    companion object {
        @Provides
        @ActivityScope
        fun provideColorState(): ColorState = ColorStateImpl()
    }
}