package ru.otus.daggerhomework.di.fragment

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
interface FragmentReceiverComponentModule {

    @Binds
    fun provideStateFlow(
        flow: MutableStateFlow<Int>
    ): StateFlow<Int>
}