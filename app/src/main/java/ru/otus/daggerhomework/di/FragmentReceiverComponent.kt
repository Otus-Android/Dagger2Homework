package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@Component(dependencies = [ApplicationComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)

}