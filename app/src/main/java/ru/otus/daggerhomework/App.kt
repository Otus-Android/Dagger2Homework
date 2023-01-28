package ru.otus.daggerhomework

import android.app.Application

class App: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {

        applicationComponent =
            DaggerApplicationComponent
                .factory()
                .create(this)

        super.onCreate()
    }

}