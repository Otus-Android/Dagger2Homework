package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [StateFlowDependency::class])
interface FragmentReceiverComponent {
  fun inject(fragment: FragmentReceiver)

  fun getViewModelFactory(): ViewModelReceiverFactory

  @Component.Factory
  interface Factory {

    fun create(stateFlowDependency: StateFlowDependency): FragmentReceiverComponent
  }
}
