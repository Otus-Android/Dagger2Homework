package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent

class App : Application() {

    private var appComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.create(this)
    }

    fun getAppComponent() = appComponent ?: ApplicationComponent.create(this).also {
        appComponent = it
    }
}
