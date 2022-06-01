package ru.otus.daggerhomework.di.fragment

import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver

@Subcomponent(modules = [FragmentReceiverComponentModule::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentReceiverComponent
    }
}

@Module
class FragmentReceiverComponentModule