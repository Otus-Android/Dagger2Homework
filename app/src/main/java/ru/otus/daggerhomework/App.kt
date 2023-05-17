package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent

class App : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = ApplicationComponent.getApplicationComponent(applicationContext)
    }

    fun getApplicationComponent() = applicationComponent
}
