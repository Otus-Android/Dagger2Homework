package ru.otus.daggerhomework.di.dependencies

import android.content.Context
import ru.otus.daggerhomework.utils.ApplicationContext

interface MainActivityDependencies {
    @ApplicationContext
    fun appContext(): Context
}