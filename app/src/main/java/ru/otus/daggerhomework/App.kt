package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App :Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    companion object {
        fun appComponent(context: Context) =
            (context.applicationContext as App).applicationComponent
    }
}