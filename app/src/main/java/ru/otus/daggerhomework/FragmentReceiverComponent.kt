package ru.otus.daggerhomework

import dagger.Subcomponent

@FragmentReceiverScope
@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}