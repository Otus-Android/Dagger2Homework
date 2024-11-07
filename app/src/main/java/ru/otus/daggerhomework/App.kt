package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.AppComponent
import ru.otus.daggerhomework.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var component: AppComponent
    }
}