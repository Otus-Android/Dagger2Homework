package ru.otus.daggerhomework

import android.app.Application
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}