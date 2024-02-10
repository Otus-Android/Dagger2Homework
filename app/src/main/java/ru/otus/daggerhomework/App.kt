package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerAppComponent

class App :Application() {
    val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.factory().create(applicationContext)
    }
}