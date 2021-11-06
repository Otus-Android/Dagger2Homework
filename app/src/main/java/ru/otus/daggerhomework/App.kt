package ru.otus.daggerhomework

import android.app.Application

class App : Application(), DependenciesProvider<MainActivityDependencies> {
    
    lateinit var appComponent: ApplicationComponent
    
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
    
    override fun getDependencies(): MainActivityDependencies = appComponent
    
}