package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver

@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentReceiverComponent
    }

/*
    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentProducerComponent
    }*/

    fun inject(fragment: FragmentReceiver)


}