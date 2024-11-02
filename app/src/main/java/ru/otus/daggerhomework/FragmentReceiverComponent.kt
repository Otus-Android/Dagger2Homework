package ru.otus.daggerhomework

import dagger.Subcomponent

@Subcomponent
interface FragmentReceiverComponent {

    fun inject(receiverFragment: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}