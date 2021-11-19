package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver
import ru.otus.daggerhomework.presentation.receiver.ViewModelReceiver
import ru.otus.daggerhomework.utils.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    fun inject(fragment: ViewModelReceiver)

}