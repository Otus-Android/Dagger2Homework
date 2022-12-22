package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.ActivityScope


@Module
interface ColorGeneratorModule {
    @Binds
    @ActivityScope
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}