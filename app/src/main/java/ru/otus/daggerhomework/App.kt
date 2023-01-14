package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.dagger.ApplicationComponent
import ru.otus.daggerhomework.dagger.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }
}
