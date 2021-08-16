package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(modules = [ProducerModule2::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Builder
    interface Builder {

        fun mainComponent(mainActivityComponent: MainActivityComponent): Builder

        fun build(): FragmentReceiverComponent
    }
}