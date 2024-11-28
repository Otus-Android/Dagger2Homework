package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.factory().create(this)
    }

    fun getAppComponent(): ApplicationComponent = component
}