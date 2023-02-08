package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ActivityScope
import ru.otus.daggerhomework.EventBus

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideChannel(): EventBus {
        return EventBus()
    }

}