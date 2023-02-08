package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {

  fun inject(fragmentReceiver: FragmentReceiver)
}