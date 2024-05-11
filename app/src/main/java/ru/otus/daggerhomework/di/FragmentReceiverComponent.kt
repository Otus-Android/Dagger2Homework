package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)
}
