package ru.otus.daggerhomework

import android.app.Application
import kotlin.properties.Delegates

class App : Application() {

    var appComponent by Delegates.notNull<ApplicationComponent>()
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }

    }