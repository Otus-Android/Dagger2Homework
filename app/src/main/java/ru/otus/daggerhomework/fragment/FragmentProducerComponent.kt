package ru.otus.daggerhomework.fragment

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [ColorModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

}