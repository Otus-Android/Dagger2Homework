package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [ApplicationComponent::class])
@FragmentScope
interface ProducerFragmentComponent {
}