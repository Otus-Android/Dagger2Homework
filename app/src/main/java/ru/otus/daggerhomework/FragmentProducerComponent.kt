package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    dependencies = [FragmentProducerDependencies::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {
    fun inject(fragment: FragmentProducer)
}