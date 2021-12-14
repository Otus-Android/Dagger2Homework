package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    companion object {
        private lateinit var appComponent: ApplicationComponent

        fun appComponent(): ApplicationComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}