package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [MainActivityComponent::class, ApplicationComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, applicationComponent: ApplicationComponent): FragmentProducerComponent
    }
}