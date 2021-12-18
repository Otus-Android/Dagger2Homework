package ru.otus.daggerhomework

import android.content.Context
import ru.otus.daggerhomework.app.App
import ru.otus.daggerhomework.app.ApplicationComponent

val Context.appComponent: ApplicationComponent
    get() = (applicationContext as App).appComponent
