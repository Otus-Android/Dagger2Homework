package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface GenerateModule {

    @Binds
    fun bindColor(colorGeneratorImpl :ColorGeneratorImpl): ColorGenerator
}