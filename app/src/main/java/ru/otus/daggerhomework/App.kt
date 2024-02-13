package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

open class App :Application() {

     private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }

    open fun getAppComponent(): ApplicationComponent {
        return appComponent
    }
}