package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
abstract class ProducerModule {

    @Binds
    abstract fun bindColorGeneration(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}