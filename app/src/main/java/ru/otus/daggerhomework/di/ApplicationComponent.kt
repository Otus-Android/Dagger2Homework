package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

  @Named("application")
  fun provideAppContext(): Context

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance @Named("application") appContext: Context): ApplicationComponent
  }
}

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope
