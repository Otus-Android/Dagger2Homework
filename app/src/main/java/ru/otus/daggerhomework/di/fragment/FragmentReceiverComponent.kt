package ru.otus.daggerhomework.di.fragment

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.scopes.FragmentScope

@FragmentScope
@Subcomponent
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}