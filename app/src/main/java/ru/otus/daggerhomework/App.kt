package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
    companion object{
        lateinit var component: ApplicationComponent
    }
    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.factory().create(this)
    }
}