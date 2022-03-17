package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    private var _appComponent: ApplicationComponent? = null

    val appComponent: ApplicationComponent
        get() = _appComponent ?: DaggerApplicationComponent
            .factory()
            .create(this)
            .also { _appComponent = it }

    override fun onCreate() {
        super.onCreate()
        appComponent
    }
}