package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class]
)
@FragmentScope
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)
}