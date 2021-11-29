package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.AppComponent
import ru.otus.daggerhomework.di.DaggerAppComponent


class App : Application() {

    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        appComponent = DaggerAppComponent
            .factory()
            .create(this)

        super.onCreate()
    }
}