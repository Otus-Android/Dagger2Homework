package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {
  fun inject(receiver: FragmentReceiver)
}
