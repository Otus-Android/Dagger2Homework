package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface UtilsModule {
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}