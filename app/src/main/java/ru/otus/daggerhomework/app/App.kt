package ru.otus.daggerhomework.app

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.util.unsafeLazy

class App : Application() {

    val appComponent by unsafeLazy {
        ApplicationComponent.factory().create(applicationContext)
    }
}

