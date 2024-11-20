package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [ColorGeneratorModule::class, ViewModelProducerModule::class])
interface FragmentProducerComponent {
    fun inject(fragment: FragmentProducer)
}


