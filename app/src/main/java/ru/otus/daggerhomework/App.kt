package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.components.ApplicationComponent
import ru.otus.daggerhomework.components.DaggerApplicationComponent
import ru.otus.daggerhomework.components.DataModule

class App :Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this, DataModule())
    }
}