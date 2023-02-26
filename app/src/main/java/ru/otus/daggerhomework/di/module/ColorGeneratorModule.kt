package ru.otus.daggerhomework.di.module

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
interface ColorGeneratorModule {

  @Binds
  fun bind(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}