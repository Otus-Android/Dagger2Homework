package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class]
)
interface FragmentReceiverComponent {
    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}