package ru.otus.daggerhomework

import dagger.Component
import dagger.Subcomponent

@Subcomponent
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}