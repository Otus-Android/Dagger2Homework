package ru.otus.daggerhomework.receiver.di

import dagger.Component
import ru.otus.daggerhomework.FragmentScope
import ru.otus.daggerhomework.activity.di.MainActivityComponent
import ru.otus.daggerhomework.receiver.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}