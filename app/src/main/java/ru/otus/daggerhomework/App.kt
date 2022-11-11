package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
    private lateinit var _applicationComponent: ApplicationComponent
    val applicationComponent: ApplicationComponent get() = _applicationComponent

    override fun onCreate() {
        super.onCreate()
        _applicationComponent = DaggerApplicationComponent.factory().create(this)

    }
}