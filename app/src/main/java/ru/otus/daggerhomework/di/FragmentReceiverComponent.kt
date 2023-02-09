package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }

}