package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [
        MainActivityComponent::class
    ]
)
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
}