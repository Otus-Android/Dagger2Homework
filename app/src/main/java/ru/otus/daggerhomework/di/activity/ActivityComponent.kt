package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.application.ApplicationComponent
import ru.otus.daggerhomework.di.application.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(
  dependencies = [ApplicationComponent::class],
  modules = [ActivityModule::class]
)
interface ActivityComponent {

  @ActivityContext
  fun activityContext(): Context

  @ApplicationContext
  fun applicationContext(): Context

  fun source(): MutableStateFlow<Int>

  fun inject(mainActivity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance @ActivityContext context: Context,
      applicationComponent: ApplicationComponent
    ): ActivityComponent
  }
}