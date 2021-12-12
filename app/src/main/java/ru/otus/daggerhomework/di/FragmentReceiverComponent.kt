package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.ui.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentReceiverComponent
    }
}