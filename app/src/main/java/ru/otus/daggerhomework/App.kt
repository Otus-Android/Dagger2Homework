package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent =
            DaggerApplicationComponent.factory().create(context = this)
    }

    fun getAppComponent() = appComponent

}