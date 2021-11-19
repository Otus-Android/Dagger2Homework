package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.presentation.producer.FragmentProducer
import ru.otus.daggerhomework.presentation.producer.ViewModelProducer
import ru.otus.daggerhomework.utils.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(viewModel: ViewModelProducer)

    fun inject(fragment: FragmentProducer)

}




