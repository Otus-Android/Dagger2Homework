package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
}