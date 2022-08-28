package ru.otus.daggerhomework.di.activity

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
object ActivityModule {

  @Singleton
  @Provides
  fun provideSource(): MutableStateFlow<Int> {
    return MutableStateFlow(0)
  }
}
