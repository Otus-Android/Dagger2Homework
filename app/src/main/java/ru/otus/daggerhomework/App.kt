package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.components.AppComponent
import ru.otus.daggerhomework.di.components.DaggerAppComponent
import ru.otus.daggerhomework.di.dependencies.DependenciesProvider
import ru.otus.daggerhomework.di.dependencies.MainActivityDependencies

class App : Application(), DependenciesProvider<MainActivityDependencies> {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent
            .factory()
            .create(this)

        super.onCreate()
    }

    override fun getDependencies(): MainActivityDependencies = appComponent
}