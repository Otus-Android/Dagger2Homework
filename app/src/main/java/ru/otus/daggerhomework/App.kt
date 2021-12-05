package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {
    val component by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}