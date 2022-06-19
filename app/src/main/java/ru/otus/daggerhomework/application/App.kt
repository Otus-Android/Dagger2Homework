package ru.otus.daggerhomework.application

import android.app.Application
import ru.otus.daggerhomework.application.di.ApplicationComponent
import ru.otus.daggerhomework.application.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}