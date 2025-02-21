package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.component.ApplicationComponent
import ru.otus.daggerhomework.di.component.DaggerApplicationComponent
import ru.otus.daggerhomework.di.component.MainActivityComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this.applicationContext)
    }
}
val Application.appComponent: ApplicationComponent get() = (this as App).appComponent