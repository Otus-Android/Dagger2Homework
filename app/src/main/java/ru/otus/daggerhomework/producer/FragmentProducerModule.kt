package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}