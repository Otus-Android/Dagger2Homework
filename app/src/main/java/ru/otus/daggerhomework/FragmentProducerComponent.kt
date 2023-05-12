package ru.otus.daggerhomework

import dagger.Subcomponent

@Subcomponent
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}