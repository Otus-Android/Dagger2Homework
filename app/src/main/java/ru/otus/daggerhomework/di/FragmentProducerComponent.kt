package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [ProducerFragmentModule::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}