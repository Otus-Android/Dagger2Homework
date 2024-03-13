package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@Subcomponent
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
}