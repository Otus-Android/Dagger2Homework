package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    dependencies = [FragmentReceiverDependencies::class],
)
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
}