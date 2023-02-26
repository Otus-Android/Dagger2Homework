package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.component.ApplicationComponent

class App :Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.create(this)
    }
}