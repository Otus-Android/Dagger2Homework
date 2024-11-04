package ru.otus.daggerhomework.fragments

import dagger.Module
import dagger.Subcomponent
import javax.inject.Singleton

@Module
class FragmentReceiverModule

@Singleton
@FragmentScope
@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiveComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiveComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}