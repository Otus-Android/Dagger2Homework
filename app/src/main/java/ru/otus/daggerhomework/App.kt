package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.ApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = ApplicationComponent.createComponent(this)
    }

    fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }

}