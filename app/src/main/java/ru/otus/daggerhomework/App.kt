package ru.otus.daggerhomework

import android.app.Application

class App: Application() {

    private val applicationComponent: ApplicationComponent = DaggerApplicationComponent.factory().create(this)

    fun getApplicationComponent() = applicationComponent
}