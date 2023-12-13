package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, ): FragmentProducerComponent
    }
}
