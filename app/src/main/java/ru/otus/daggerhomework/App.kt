package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.ApplicationComponent
import ru.otus.daggerhomework.di.components.DaggerApplicationComponent

class App : Application() {

    companion object {
        private var appComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        getAppComponent().inject(this)
    }

    fun getAppComponent(): ApplicationComponent {
        return appComponent ?: DaggerApplicationComponent.factory().create(this).also { appComponent = it }
    }

}