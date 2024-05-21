package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.di.annotations.FragmentScope
import ru.otus.daggerhomework.ui.receiver.FragmentReceiver
import ru.otus.daggerhomework.ui.receiver.ViewModelReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    fun provideViewModelReceiver(): ViewModelReceiver

    fun inject(fragmentReceiver: FragmentReceiver)
}