package ru.otus.daggerhomework

import android.app.Application
import android.util.Log
import ru.otus.daggerhomework.di.components.ApplicationComponent
import ru.otus.daggerhomework.di.components.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        Log.i("!!!", "app 1: ")

        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .context(this)
            .build()

        Log.i("!!!", "app 2: ")

    }
}