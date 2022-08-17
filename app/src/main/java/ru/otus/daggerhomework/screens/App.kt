package ru.otus.daggerhomework.screens

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    private var INSTANCE: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory()
            .create(applicationContext)
            .also { component -> INSTANCE = component }
    }

    fun getComponentInstance() =
        INSTANCE ?: throw IllegalStateException("Application component is null!")
}