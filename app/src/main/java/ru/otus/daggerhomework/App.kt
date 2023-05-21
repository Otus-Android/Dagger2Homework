package ru.otus.daggerhomework

import android.app.Application
import javax.inject.Inject

class App :Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        appComponent = DaggerApplicationComponent.factory().create(this)
        super.onCreate()
    }
}