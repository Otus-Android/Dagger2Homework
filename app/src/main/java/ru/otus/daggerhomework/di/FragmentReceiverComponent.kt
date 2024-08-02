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
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}