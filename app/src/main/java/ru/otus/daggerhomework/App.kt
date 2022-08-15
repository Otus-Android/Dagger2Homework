package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    private var _appComponent: ApplicationComponent? = null

    val appComponent: ApplicationComponent
        get() = _appComponent ?: DaggerApplicationComponent
            .factory()
            .build(this)
            .also { _appComponent = it }

    override fun onCreate() {
        super.onCreate()
        appComponent
    }

}