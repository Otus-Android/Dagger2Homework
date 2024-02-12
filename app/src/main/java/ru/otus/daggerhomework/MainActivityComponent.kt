package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [BindsMainModule::class, MainModule::class],
    dependencies = [ApplicationComponent::class])
interface MainActivityComponent : StateFlowDependency {

  @Component.Factory
  interface Factory {
    fun getComponent(
        @BindsInstance @ActivityContext context: Context,
        applicationComponent: ApplicationComponent
    ): StateFlowDependency
  }
}
