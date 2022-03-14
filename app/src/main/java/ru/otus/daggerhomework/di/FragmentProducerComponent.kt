package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
  fun inject(producer: FragmentProducer)
}



