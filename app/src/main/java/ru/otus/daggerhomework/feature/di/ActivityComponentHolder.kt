package ru.otus.daggerhomework.feature.di

import android.content.Context
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.activity.DaggerMainActivityComponent
import ru.otus.daggerhomework.activity.MainActivityComponent

object ActivityComponentHolder {
    private var activityComponent: MainActivityComponent? = null

    fun getActivityComponent(context: Context, app: App): MainActivityComponent =
        activityComponent ?: DaggerMainActivityComponent.factory()
            .create(app.getAppComponent(), context)
            .also {
                activityComponent = it
            }

    fun clear() {
        activityComponent = null
    }
}