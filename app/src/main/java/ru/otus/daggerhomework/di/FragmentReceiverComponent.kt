package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@Component(
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}