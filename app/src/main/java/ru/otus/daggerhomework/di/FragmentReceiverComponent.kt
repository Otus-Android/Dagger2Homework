package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}