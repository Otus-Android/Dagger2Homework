package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.features.producer.FragmentProducer

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent : DaggerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityComponent: MainActivityComponent,
        ): FragmentProducerComponent
    }
}