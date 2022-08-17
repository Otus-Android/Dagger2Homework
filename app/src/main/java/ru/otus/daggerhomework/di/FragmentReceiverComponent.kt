package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [ApplicationComponent::class, ActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent,
            mainActivityComponent: ActivityComponent
        ): FragmentReceiverComponent
    }
}