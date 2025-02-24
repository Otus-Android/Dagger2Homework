package ru.otus.daggerhomework.di


import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Builder
    interface Builder {
        fun create (): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}