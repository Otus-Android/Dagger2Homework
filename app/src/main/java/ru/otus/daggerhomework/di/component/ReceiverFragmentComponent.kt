package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.ReceiverFragment
import ru.otus.daggerhomework.ReceiverViewModel
import ru.otus.daggerhomework.di.scope.FragmentScope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface ReceiverFragmentComponent {


    @Component.Factory
    interface Factory {
        fun create(
            activityComponent: MainActivityComponent,
        ): ReceiverFragmentComponent
    }

    fun inject(receiverFragment: ReceiverFragment)
    fun getReceiverViewModel(): ReceiverViewModel
}