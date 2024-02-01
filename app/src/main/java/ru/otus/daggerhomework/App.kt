package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App :Application() {

    val appComponent = DaggerApplicationComponent.factory().create(this)
}