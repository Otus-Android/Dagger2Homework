package ru.otus.daggerhomework

import dagger.Component


@Component(dependencies = [MainActivityComponent::class])
@FragmentScope
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }

}
