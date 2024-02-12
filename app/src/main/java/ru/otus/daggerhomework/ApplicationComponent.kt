package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface ApplicationComponent {
  @ApplicationContext fun getContext(): Context

  @Component.Factory
  interface Factory {
    fun getComponent(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
  }
}

@Qualifier annotation class ApplicationContext

@Qualifier annotation class ActivityContext
