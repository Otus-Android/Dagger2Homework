package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    val component: ApplicationComponent
        get() = _component
    private lateinit var _component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        _component = DaggerAppComponent.factory().create(this)
    }
}
