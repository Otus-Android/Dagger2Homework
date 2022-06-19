package ru.otus.daggerhomework.activity.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ActivityScope

@Module
class MainActivityModule {
    @ActivityScope
    @Provides
    fun provideColorStateFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }
}