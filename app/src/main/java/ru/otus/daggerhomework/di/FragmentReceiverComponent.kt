package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.presentation.FragmentReceiver

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {

        fun create(appComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}