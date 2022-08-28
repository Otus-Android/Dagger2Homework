package ru.otus.daggerhomework.di.applicatoin

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.quialifiers.ApplicationContext

@Component
interface ApplicationComponent {

  fun mainActivityComponentFactory(): ActivityComponent.Factory

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
  }
}