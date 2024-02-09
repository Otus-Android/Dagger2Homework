package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.util.ColorGenerator
import ru.otus.daggerhomework.util.ColorGeneratorImpl

@Module
interface FragmentProducerModule {

    @Binds fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}
