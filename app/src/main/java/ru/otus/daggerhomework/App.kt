package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.application.DaggerApplicationComponent

class App :Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

   /* lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }*/
}