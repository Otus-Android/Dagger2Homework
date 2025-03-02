package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [ProducerFragmentModule::class])
interface ProducerFragmentComponent {
    fun inject(producerFragment: ProducerFragment)
}

@Module
interface ProducerFragmentModule {

    @Binds
    fun bindsColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}