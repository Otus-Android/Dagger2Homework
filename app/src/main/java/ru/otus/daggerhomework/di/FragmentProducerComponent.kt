package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}
