package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer

@Subcomponent
interface FragmentProducerComponent {

    val viewModel: ViewModelProducer

    fun inject(fragment: FragmentProducer)
}