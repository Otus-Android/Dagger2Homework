package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.ApplicationComponent
import ru.otus.daggerhomework.di.components.DaggerApplicationComponent

class App : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .factory()
            .create(this)

    }

}