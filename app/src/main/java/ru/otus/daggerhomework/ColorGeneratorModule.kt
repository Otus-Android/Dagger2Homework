package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorGeneratorModule {

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

}