package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorGeneratorModule {
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGenerator): IColorGenerator
}