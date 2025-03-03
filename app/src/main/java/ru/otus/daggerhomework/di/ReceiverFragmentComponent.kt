package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ReceiverFragment

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface ReceiverFragmentComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): ReceiverFragmentComponent
    }

    fun inject(fragment: ReceiverFragment)
}