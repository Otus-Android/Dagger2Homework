package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver


@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Builder
    interface Builder {
        fun create (): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}