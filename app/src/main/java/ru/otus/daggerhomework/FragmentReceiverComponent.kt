package ru.otus.daggerhomework

import dagger.Subcomponent

@Subcomponent
interface FragmentReceiverComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}