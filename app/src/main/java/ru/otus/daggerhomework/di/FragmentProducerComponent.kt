package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {

    fun inject(producerFragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}