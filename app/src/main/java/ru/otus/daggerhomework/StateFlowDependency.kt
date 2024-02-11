package ru.otus.daggerhomework

import android.content.Context
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext

interface StateFlowDependency {
    fun getStateFlow(): StateObserver

    @ApplicationContext
    fun getApplicationContext(): Context

    @ActivityContext
    fun getContext(): Context
}
