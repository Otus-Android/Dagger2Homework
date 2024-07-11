package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Subcomponent
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
}

interface FragmentReceiverComponentHolder {
    fun getReceiverComponent(): FragmentReceiverComponent
}