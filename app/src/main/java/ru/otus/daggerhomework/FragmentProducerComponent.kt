package ru.otus.daggerhomework

import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)

}