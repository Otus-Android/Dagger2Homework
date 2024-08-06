package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }
}

val Context.applicationComponent: ApplicationComponent
    get() = when (this)  {
        is App -> applicationComponent
        else -> applicationContext.applicationComponent
    }