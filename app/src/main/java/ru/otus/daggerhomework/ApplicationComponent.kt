package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class ContextApplication

@Singleton
@Component()
interface ApplicationComponent {

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance @ContextApplication context: Context,
    ): ApplicationComponent
  }

  @ContextApplication
  fun provideApplicationContext(): Context
}