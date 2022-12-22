package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.ApplicationComponent
import ru.otus.daggerhomework.di.components.DaggerApplicationComponent

class App : Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent
            .factory()
            .create(this)
    }
}