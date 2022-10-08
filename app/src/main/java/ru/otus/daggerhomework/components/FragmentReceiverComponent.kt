package ru.otus.daggerhomework.components

import dagger.Component
import ru.otus.daggerhomework.receivers.FragmentReceiver
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver);

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}