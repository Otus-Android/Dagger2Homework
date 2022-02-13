package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {
    fun inject(fragment: FragmentProducer)
}