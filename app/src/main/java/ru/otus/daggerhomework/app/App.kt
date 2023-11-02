package ru.otus.daggerhomework.app

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.ComponentProvider
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application(), ComponentProvider<ApplicationComponent> {

    private lateinit var _appComponent: ApplicationComponent

    override val component: ApplicationComponent
        get() = _appComponent

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerApplicationComponent.factory().create(this)
    }
}