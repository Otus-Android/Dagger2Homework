package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.receiver.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}