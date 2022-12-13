package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentReceiverScope

@FragmentReceiverScope
@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}