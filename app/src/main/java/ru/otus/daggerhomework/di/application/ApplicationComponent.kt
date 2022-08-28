package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

  @ApplicationContext
  fun context(): Context

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
  }
}