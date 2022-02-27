package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ColorGeneratorModule {

    @Provides
    @Singleton
     fun provideColorGenerator():ColorGenerator {
        return ColorGeneratorImpl()
    }

}