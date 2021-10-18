package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides

@Module
class ColorModule {

    @Provides
    @FragmentScope
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}