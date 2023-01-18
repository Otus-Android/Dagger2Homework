package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@Component(dependencies = [ApplicationComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)

}