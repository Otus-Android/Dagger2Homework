package ru.otus.daggerhomework

import android.app.Application
import android.util.Log

private const val TAG = "AppTag"

class App :Application() {
    private lateinit var _applicationComponent: ApplicationComponent
    val applicationComponent: ApplicationComponent get() = _applicationComponent

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

        _applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}