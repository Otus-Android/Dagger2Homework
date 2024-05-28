package ru.otus.daggerhomework

import android.app.Application

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    initializeDI()
  }

  fun getApplicationComponent(): ApplicationComponent = appComponent

  private fun initializeDI() {
    appComponent = DaggerApplicationComponent.factory()
      .create(this)
  }

  companion object {
    private lateinit var appComponent: ApplicationComponent
  }
}