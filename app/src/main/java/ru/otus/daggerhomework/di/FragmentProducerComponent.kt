package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@Component(
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentProducerComponent {
    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}