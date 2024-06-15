package ru.otus.daggerhomework.di.application

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
interface AppModule {
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}
