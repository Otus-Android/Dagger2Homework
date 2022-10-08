package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.components.ApplicationComponent
import ru.otus.daggerhomework.components.DaggerApplicationComponent

class App : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().add(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }

}