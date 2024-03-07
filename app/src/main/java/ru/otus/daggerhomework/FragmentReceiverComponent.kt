package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [MainActivityComponent::class, ApplicationComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, applicationComponent: ApplicationComponent): FragmentReceiverComponent
    }
}