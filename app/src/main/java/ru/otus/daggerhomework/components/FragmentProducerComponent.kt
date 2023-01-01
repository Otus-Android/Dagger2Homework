package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.AppModule
import ru.otus.daggerhomework.producer.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)
}