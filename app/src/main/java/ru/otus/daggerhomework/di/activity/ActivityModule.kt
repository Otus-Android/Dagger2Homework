package ru.otus.daggerhomework.di.activity

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
object ActivityModule {

  @PerActivity
  @Provides
  fun provideSource(): StateFlow<Int> {
    return MutableStateFlow(0)
  }
}
