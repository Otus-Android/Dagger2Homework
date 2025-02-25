package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ReceiverFragment

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface ReceiverFragmentComponent {
    fun inject(receiverFragment: ReceiverFragment)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): ReceiverFragmentComponent
    }

}