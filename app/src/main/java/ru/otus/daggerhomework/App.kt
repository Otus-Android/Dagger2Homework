package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App :Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }
}

val Context.appComponent: ApplicationComponent
    get() = when(this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }