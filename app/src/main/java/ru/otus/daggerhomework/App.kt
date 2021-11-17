package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.ApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerApplicationComponent
//            .builder()
//            .context(this)
//            .build()


    }
}