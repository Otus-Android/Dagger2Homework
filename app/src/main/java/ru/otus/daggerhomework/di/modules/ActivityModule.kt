package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl

@Module
interface ActivityModule {
    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}