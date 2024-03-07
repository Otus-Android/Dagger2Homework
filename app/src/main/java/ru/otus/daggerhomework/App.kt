package ru.otus.daggerhomework

import android.app.Application

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory().create(this)
    }
}