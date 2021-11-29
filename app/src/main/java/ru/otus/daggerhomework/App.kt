package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent



class App() : Application() {

    override fun onCreate() {
        appComponentMain = DaggerApplicationComponent.factory().create(this)
        super.onCreate()
    }
    companion object {
        lateinit var appComponentMain: ApplicationComponent
    }
}