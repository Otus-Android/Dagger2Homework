package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.presentation.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

    fun inject(receiverFragment: FragmentReceiver)
}