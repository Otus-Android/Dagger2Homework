package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

}