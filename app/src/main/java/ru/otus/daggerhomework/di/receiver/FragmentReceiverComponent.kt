package ru.otus.daggerhomework.di.receiver

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope

@FragmentScope
@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    fun inject(receiver: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}