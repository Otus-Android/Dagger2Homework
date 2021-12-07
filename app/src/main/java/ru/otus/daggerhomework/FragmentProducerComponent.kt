package ru.otus.daggerhomework

import dagger.Component

@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentProducerComponent {

    fun injectProducerDependencies(fragment: FragmentProducer)
}