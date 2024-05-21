package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.di.annotations.FragmentScope
import ru.otus.daggerhomework.ui.receiver.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
}