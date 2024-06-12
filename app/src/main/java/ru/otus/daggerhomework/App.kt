package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
    val component = DaggerApplicationComponent.factory().create(this)
}