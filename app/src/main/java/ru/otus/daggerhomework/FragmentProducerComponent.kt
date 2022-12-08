package ru.otus.daggerhomework

import dagger.Subcomponent

@FragmentProducerScope
@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}
