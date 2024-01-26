package ru.otus.daggerhomework.di.app

import android.app.Application
import android.content.Context
import ru.otus.daggerhomework.di.app.DaggerApplicationComponent

class App : Application() {

    private var _applicationComponent: ApplicationComponent? = null
    val applicationComponent: ApplicationComponent
        get() = checkNotNull(_applicationComponent)

    override fun onCreate() {
        super.onCreate()
        _applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

}

val Context.appComponent: ApplicationComponent
    get() {
        return when (this) {
            is App -> applicationComponent
            else -> this.applicationContext.appComponent
        }
    }