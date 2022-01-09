package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.AppComponent
import ru.otus.daggerhomework.di.components.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
    }
}