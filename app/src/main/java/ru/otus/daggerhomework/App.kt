package ru.otus.daggerhomework

import android.app.Application

class App :Application() {

    lateinit var component: ApplicationComponent

    init {
        component = DaggerApplicationComponent.factory().create(this)
    }
}