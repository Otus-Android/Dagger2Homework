package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    private val appComponent: ApplicationComponent by lazy { ApplicationComponent.init(this) }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    fun getApplicationComponent() = appComponent
}