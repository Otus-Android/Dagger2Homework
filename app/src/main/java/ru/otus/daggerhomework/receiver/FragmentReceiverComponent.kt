package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.MainActivityComponent
import ru.otus.daggerhomework.di.FragmentScope


@Component(
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
    fun inject(fragmentReceiver: FragmentReceiver)

}