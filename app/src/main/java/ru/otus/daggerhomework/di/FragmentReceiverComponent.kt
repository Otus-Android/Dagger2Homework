package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    @Component.Factory
    interface factory {
        fun create(comp: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(f: FragmentReceiver)
}