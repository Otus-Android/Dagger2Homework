package ru.otus.daggerhomework.components

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)
}