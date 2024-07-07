package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)

    fun provideColorObserver(): ColorObserver
}