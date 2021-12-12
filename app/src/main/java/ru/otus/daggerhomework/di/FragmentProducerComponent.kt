package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.ui.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {
    fun inject(fragment: FragmentProducer)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentProducerComponent
    }
}