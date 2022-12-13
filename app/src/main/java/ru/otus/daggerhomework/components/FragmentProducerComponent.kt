package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentProducerScope

@FragmentProducerScope
@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}
