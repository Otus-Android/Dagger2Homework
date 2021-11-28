package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Lazy
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.receiver.FragmentReceiver
import ru.otus.daggerhomework.receiver.ViewModelReceiver

@FragmentScope
@Subcomponent()
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)

}



@FragmentScope
@Subcomponent()
interface FragmentReceiverComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)

}



