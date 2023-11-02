package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.features.receiver.FragmentReceiver

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent : DaggerComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }
}