package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import ru.otus.daggerhomework.di.application.ApplicationComponent
import ru.otus.daggerhomework.di.application.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent
            .factory()
            .create(this)
    }
}

val Context.applicationComponent: ApplicationComponent
    get() = (applicationContext as App).appComponent