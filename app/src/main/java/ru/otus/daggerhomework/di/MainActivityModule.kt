package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.di.scopes.CustomActivityScope

@Module
object MainActivityModule {
    @JvmStatic
    @Provides
    @CustomActivityScope
    fun provideEventChannel(): MutableSharedFlow<Int> {
        return MutableSharedFlow()
    }
}