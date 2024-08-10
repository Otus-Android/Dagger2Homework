package ru.otus.daggerhomework

import dagger.Module
import dagger.Subcomponent

@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

    fun inject(receiverFragment: FragmentReceiver)
}

@Module(subcomponents = [FragmentReceiverComponent::class])
interface ReceiverModule