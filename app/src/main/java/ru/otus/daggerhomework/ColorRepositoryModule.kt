package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorRepositoryModule {

  @ActivityScope
  @Binds
  fun colorRepository(impl: ColorRepositoryImpl): ColorRepository
}