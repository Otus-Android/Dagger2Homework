package ru.otus.daggerhomework.modules

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
abstract class ColorGeneratorModule {
    @Binds
    abstract fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

}