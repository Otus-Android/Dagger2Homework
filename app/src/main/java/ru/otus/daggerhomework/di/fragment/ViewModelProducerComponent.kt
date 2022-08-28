package ru.otus.daggerhomework.di.fragment

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.activity.ActivityComponent

@PerFragment
@Component(dependencies = [ActivityComponent::class], modules = [ColorGeneratorModule::class])
interface ViewModelProducerComponent {

  fun inject(fragmentProducer: FragmentProducer)

  @Component.Factory
  interface Factory {
    fun create(activityComponent: ActivityComponent): ViewModelProducerComponent
  }
}