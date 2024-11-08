package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
interface ColorGeneratorModule {

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}