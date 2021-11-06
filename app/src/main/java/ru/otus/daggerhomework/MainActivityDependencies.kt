package ru.otus.daggerhomework

import android.content.Context
import javax.inject.Named

interface MainActivityDependencies {
    @Named(NAME_APP_CONTEXT)
    fun appContext(): Context
}