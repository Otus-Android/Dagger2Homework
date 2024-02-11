package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver


@FragmentScope
@Component(
    dependencies = [ActivityComponent::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(parentComponent: ActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}