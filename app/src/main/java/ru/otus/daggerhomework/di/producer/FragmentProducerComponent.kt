package ru.otus.daggerhomework.di.producer

import dagger.Subcomponent
import ru.otus.daggerhomework.presentation.producer.FragmentProducer
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope

@FragmentScope
@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    fun inject(producer: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}