package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface BindsProducerModule {
  @Binds fun getColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}
