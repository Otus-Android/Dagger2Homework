package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.app.ApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        ApplicationComponent.init(this.applicationContext)
    }

}