package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
}