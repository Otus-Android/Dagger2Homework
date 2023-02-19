package ru.otus.daggerhomework.components

import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.receiver.FragmentReceiver
import ru.otus.daggerhomework.receiver.ViewModelFactory
import javax.inject.Singleton

@Subcomponent
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
    fun provideViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory{
        fun create(): FragmentReceiverComponent
    }
}