package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module

@FragmentScope
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [MainActivityComponent::class],
)
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

}

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}