package ru.otus.daggerhomework.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.scopes.ActivityScope

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideColor() : MutableStateFlow<Int?> {
        return MutableStateFlow(0)
    }
}