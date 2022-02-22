package ru.otus.daggerhomework

import android.app.Application
import java.lang.ref.WeakReference

class App :Application() {
    companion object{
        lateinit var applicationComponent: ApplicationComponent
    }
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(WeakReference(this))
    }
}