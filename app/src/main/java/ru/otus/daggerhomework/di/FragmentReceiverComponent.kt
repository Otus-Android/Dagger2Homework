package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.FragmentReceiver

@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): FragmentReceiverComponent
    }

}