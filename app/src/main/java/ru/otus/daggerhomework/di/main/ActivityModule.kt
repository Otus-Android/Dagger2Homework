package ru.otus.daggerhomework.di.main

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
interface ActivityModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}