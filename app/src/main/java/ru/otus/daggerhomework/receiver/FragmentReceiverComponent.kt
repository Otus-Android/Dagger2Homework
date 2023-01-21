package ru.otus.daggerhomework.receiver

import dagger.Subcomponent
import ru.otus.daggerhomework.applicaion.ViewModelFactory
import javax.inject.Singleton

@Subcomponent
@Singleton
interface FragmentReceiverComponent {

    fun injectToFragmentReceiver(fragmentReceiver: FragmentReceiver)
    fun viewModelFactory(): ViewModelFactory

}