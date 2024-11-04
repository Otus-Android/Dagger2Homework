package ru.otus.daggerhomework.main

import android.app.Application
import javax.inject.Scope

class App : Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }
}

@Scope
annotation class ApplicationScope