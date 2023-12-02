package ru.otus.daggerhomework.di

import android.app.Application

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .factory()
            .create(this)
    }
}

