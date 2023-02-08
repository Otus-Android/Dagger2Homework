package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@ProducerComponentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface ProducerComponentFactory{
        fun create(mainActivityComponent: MainActivityComponent):FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}