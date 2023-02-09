package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorGeneratorModule {

  @Binds
  fun colorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}