package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}
