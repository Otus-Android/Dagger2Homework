package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.application.ApplicationComponent
import ru.otus.daggerhomework.di.application.DaggerApplicationComponent

class App : Application() {

  private lateinit var applicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    applicationComponent = DaggerApplicationComponent.factory().create(this)
  }

  fun getApplicationComponent(): ApplicationComponent {
    return applicationComponent
  }
}