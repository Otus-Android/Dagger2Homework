package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

  lateinit var appComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerApplicationComponent.factory().getComponent(this)
  }
}
