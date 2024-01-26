package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [
        ApplicationComponent::class,
        MainActivityComponent::class
    ]
)
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
}