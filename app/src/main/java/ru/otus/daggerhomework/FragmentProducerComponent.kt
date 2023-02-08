package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [ApplicationComponent::class])
interface FragmentProducerComponent {
}