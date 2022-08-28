package ru.otus.daggerhomework.di.fragment

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.activity.ActivityComponent

@PerFragment
@Component(dependencies = [ActivityComponent::class])
interface ViewModelReceiverComponent {

  fun inject(fragmentReceiver: FragmentReceiver);

  @Component.Factory
  interface Factory {
    fun create(activityComponent: ActivityComponent): ViewModelReceiverComponent
  }
}