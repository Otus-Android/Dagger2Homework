package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope

@ProducerScope
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)
}


@Module
interface FragmentProducerModule {
    @Binds
    fun bindsColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ProducerScope