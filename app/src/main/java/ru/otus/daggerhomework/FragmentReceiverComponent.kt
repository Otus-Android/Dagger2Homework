package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
}