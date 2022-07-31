package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory().build(this)
    }

}