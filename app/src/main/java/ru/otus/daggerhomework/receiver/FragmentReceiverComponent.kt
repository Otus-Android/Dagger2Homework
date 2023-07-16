package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.activity.MainActivityComponent
import ru.otus.daggerhomework.di.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Component.Builder
    interface Builder {

        fun mainActivityComponent(mainActivityComponent: MainActivityComponent): Builder

        fun build(): FragmentReceiverComponent
    }
}