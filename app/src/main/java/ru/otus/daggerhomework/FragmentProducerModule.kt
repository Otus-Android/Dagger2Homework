package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface FragmentProducerModule {
    
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
    
}