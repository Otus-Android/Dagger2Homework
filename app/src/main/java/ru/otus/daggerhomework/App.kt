package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App :Application() {
    val applicationComponent: ApplicationComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent
    }
}