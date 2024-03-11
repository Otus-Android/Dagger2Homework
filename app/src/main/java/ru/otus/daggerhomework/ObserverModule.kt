package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
object ObserverModule {

    @Provides
    @ActivityScope
    fun provideObserver(): MutableStateFlow<Int> {
        return MutableStateFlow<Int>(0)
    }

}