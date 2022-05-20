package ru.otus.daggerhomework

import android.app.Application
import android.content.Context

class App: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }
}

val Context.applicationComponent: ApplicationComponent
    get() = when (this)  {
        is App -> applicationComponent
        else -> this.applicationContext.applicationComponent
    }