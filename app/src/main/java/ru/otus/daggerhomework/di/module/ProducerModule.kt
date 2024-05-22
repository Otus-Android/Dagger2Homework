package ru.otus.daggerhomework.di.module

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.FeatureScope

@Module
interface ProducerModule {
    @Binds
    @FeatureScope
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}