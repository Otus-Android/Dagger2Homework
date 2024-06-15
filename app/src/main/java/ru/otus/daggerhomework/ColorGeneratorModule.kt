package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorGeneratorModule {

    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}