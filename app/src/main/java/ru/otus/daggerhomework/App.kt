package ru.otus.daggerhomework

import android.app.Application

class App: Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun appComponent():ApplicationComponent {
        return appComponent;
    }


}


