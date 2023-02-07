package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class App: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {

        applicationComponent =
            DaggerApplicationComponent
                .factory()
                .create(this)



        super.onCreate()
    }

}