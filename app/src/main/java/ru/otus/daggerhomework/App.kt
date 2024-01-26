package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
    val appComponent = DaggerApplicationComponent.factory().create(this)
}