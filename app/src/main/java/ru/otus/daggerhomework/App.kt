package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
    lateinit var appCompoment: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        appCompoment = DaggerApplicationComponent.factory().newAppComponent(applicationContext)
    }

}

fun Application.asApp(): App {
    return this as App
}