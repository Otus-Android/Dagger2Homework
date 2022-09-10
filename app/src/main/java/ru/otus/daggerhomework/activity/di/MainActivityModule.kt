package ru.otus.daggerhomework.activity.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ActivityScope

@Module
class MainActivityModule {
    @ActivityScope
    @ColorState
    @Provides
    fun provideColorStateFlow(): StateFlow<Int?> {
        return MutableStateFlow(null)
    }
}