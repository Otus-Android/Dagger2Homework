package ru.otus.daggerhomework

import android.content.Context
import ru.otus.daggerhomework.app.App
import ru.otus.daggerhomework.app.ApplicationComponent

val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
