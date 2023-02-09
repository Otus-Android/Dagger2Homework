package ru.otus.daggerhomework

import dagger.Component

@Component(
  modules = [ColorGeneratorModule::class],
  dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

  fun inject(fragmentProducer: FragmentProducer)
}