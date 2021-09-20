package ru.otus.daggerhomework

import ru.otus.daggerhomework.di.DaggerApplicationComponent
import android.app.Application

class App : Application() {
    val appComponent = DaggerApplicationComponent.factory().create(this)
}