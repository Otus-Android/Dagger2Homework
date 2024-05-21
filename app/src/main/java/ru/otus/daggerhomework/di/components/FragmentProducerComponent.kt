package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.di.annotations.FragmentScope
import ru.otus.daggerhomework.ui.producer.FragmentProducer
import ru.otus.daggerhomework.ui.producer.ViewModelProducer

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {
    fun provideViewModelProducer(): ViewModelProducer

    fun inject(fragmentProducer: FragmentProducer)
}