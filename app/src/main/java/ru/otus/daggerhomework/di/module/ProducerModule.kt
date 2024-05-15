package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.FeatureScope

@Module
interface ProducerModule {
    companion object {
        @Provides
        @FeatureScope
        fun provideColorGenerator(): ColorGenerator {
            return ColorGeneratorImpl()
        }
    }
}