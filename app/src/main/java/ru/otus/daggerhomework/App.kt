package ru.otus.daggerhomework

import android.app.Application

class App : Application() {
    val applicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}