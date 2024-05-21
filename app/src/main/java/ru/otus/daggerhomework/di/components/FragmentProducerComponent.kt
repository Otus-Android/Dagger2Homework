package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.di.annotations.FragmentScope
import ru.otus.daggerhomework.ui.producer.FragmentProducer

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)
}