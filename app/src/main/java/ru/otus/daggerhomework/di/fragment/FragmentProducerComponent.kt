package ru.otus.daggerhomework.di.fragment//package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [ProducerModule::class])
interface FragmentProducerComponent {

  fun inject(fragmentProducer: FragmentProducer)

  @Subcomponent.Factory
  interface Factory {
    fun create(): FragmentProducerComponent
  }
}