package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FeatureScope
@Component(dependencies = [MainActivityComponent::class], modules = [ColorGeneratorModule::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragmentReceiver: FragmentProducer)
}
