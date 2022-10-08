package ru.otus.daggerhomework.components

import dagger.Component
import ru.otus.daggerhomework.modules.ColorGeneratorModule
import ru.otus.daggerhomework.producers.FragmentProducer
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [ColorGeneratorModule::class])
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }
}