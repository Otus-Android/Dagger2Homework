package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.component.ApplicationComponent
import ru.otus.daggerhomework.di.component.DaggerApplicationComponent

class App : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}