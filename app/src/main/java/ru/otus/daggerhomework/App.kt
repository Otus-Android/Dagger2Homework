package ru.otus.daggerhomework

import android.app.Application
import android.content.Context

class App : Application() {

    lateinit var appComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}