package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [StateFlowDependency::class], modules = [BindsProducerModule::class])
interface FragmentProducerComponent {

  fun inject(fragment: FragmentProducer)

  fun getViewModelFactory(): ViewModelProviderFactory

  @Component.Factory
  interface Factory {

    fun create(stateFlowDependency: StateFlowDependency): FragmentProducerComponent
  }
}
