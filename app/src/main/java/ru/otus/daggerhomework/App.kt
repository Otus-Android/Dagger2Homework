package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.application.ApplicationComponent
import ru.otus.daggerhomework.di.application.DaggerApplicationComponent

class App : Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .factory()
            .create(this)
    }

    fun getAppComponent(): ApplicationComponent {
        return appComponent
    }
}