package ru.otus.daggerhomework.di.fragment

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
abstract class ProducerModule {

  @Binds
  abstract fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}
