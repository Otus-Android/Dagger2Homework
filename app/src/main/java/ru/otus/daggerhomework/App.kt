package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}