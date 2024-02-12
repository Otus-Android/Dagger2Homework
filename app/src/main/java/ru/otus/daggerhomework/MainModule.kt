package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object MainModule {

    @Singleton
    @Provides
    fun provideStateObserver(): StateObserverImpl {
        return StateObserverImpl()
    }
}