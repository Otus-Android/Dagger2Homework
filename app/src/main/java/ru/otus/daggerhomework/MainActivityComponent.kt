package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

  @ActivityContext
  fun activityContext(): Context

  @ApplicationContext
  fun applicationContext(): Context

  fun inject(mainActivity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance
      @ActivityContext
      context: Context,
      applicationComponent: ApplicationComponent
    ): MainActivityComponent
  }
}