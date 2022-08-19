package ru.otus.daggerhomework

import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}