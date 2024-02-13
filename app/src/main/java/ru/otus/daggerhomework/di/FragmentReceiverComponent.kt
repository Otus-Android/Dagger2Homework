package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    @Component.Factory
    interface  Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
    @FragmentScope
    fun inject(fragmentReceiver: FragmentReceiver)
}