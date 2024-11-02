package ru.otus.daggerhomework

import dagger.Subcomponent

@Subcomponent
interface FragmentProducerComponent {

    fun inject(producerFragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}