package ru.otus.daggerhomework

import dagger.*

@Module
interface ColorGeneratorModule {
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGenerator): IColorGenerator
}