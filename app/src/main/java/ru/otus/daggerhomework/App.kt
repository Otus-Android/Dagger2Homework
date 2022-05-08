package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    val appComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}