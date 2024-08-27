package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.presentation.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

    fun inject(producerFragment: FragmentProducer)
}