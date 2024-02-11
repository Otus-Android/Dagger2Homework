package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerAppComponent

class App : Application() {
    val appComponent = DaggerAppComponent.factory().create(this)
}