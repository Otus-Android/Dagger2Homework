package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.receiver.FragmentReceiver
import ru.otus.daggerhomework.receiver.ViewModelFactory
import javax.inject.Singleton

@Subcomponent
@Singleton
interface FragmentReceiverComponent {
    fun injectToFragmentReceiver(fragmentReceiver: FragmentReceiver)
    fun viewModelFactory(): ViewModelFactory
}