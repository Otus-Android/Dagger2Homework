package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.scope.FragmentScope

@Module
class ColorModule {

    @Provides
    @FragmentScope
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}