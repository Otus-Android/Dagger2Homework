package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface BindsMainModule {
    @Singleton
    @Binds
    fun getStateObserver(observer: StateObserverImpl): StateObserver
}