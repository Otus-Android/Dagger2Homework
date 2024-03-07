package ru.otus.daggerhomework

import android.app.Application

class App :
    ApplicationComponentInterface,
    Application() {

    override fun getComponent() = DaggerApplicationComponent.factory().create(this)
}