package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.app.ApplicationComponent
import ru.otus.daggerhomework.di.app.DaggerApplicationComponent

class App : Application() {

    var componentInstance: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        componentInstance =
            DaggerApplicationComponent.factory().create(context = applicationContext)
    }
}