package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer

@Subcomponent(modules = [MainModule::class])
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
    fun inject(fragmentProducer: FragmentProducer)

}