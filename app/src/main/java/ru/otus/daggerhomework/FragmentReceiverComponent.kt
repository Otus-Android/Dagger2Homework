package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class])
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
}
