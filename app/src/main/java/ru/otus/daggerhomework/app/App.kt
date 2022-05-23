package ru.otus.daggerhomework.app

import android.app.Application
import ru.otus.daggerhomework.app.di.ApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        ApplicationComponent.init(this.applicationContext)
    }

}