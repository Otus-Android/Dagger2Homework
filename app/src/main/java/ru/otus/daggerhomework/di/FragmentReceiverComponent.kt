package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.presentation.receiver.ViewModelReceiver

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    val viewModelFactory: ViewModelReceiver.Factory

    @Component.Factory
    interface Factory {

        fun create(
            component: MainActivityComponent
        ): FragmentReceiverComponent
    }

    companion object {

        fun factory(): FragmentReceiverComponent.Factory = DaggerFragmentReceiverComponent.factory()
    }
}
