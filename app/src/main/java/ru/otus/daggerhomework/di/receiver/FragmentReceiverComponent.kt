package ru.otus.daggerhomework.di.receiver

import dagger.Subcomponent
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver

@FragmentScope
@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    fun inject(receiver: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}