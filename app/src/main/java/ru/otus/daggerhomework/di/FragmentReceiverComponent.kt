package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver

@Subcomponent(modules = [ViewModelReceiverModule::class])
interface FragmentReceiverComponent {
    fun inject(fragmentReceiverComponent: FragmentReceiver)
}