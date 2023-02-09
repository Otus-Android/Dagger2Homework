package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorRepositoryModule {

  @Binds
  fun colorRepository(impl: ColorRepositoryImpl): ColorRepository
}