package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
class MainActivityModule {

  @ActivityScope
  @Provides
  fun provideState(): MutableStateFlow<Int> = MutableStateFlow(0)
}
