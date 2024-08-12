package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}