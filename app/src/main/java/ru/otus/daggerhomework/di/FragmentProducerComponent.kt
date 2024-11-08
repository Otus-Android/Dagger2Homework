package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class],
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}