package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [
        MainActivityComponent::class
    ],
    modules = [
        FragmentProducerModule::class
    ]
)
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)
}