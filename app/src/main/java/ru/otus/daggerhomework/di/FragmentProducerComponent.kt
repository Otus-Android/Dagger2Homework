package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.FragmentProducer

@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

}