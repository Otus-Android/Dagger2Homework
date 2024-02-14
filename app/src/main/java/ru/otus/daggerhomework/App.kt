package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
    override fun onCreate() {
        super.onCreate()
        initDagger()
    }
    private fun initDagger() {
        val appComponent = DaggerApplicationComponent
            .factory()
            .create(this)
        DiProvider.appComponent = appComponent
    }
}