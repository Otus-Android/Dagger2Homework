package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ProducerModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl) : ColorGenerator
}
