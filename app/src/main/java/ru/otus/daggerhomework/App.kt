package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    val appComponent by lazy {
        initializeApplicationComponent()
    }

    private fun initializeApplicationComponent() =
        DaggerApplicationComponent.factory().create(applicationContext)

}

val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }