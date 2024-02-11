package ru.otus.daggerhomework

import android.app.Application
import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent
import javax.inject.Singleton

class App :Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().getComponent(this)
    }
}

@Module
interface BindsMainModule {
    @Singleton
    @Binds
    fun getStateObserver(observer: StateObserverImpl): StateObserver
}

@Module
interface BindsProducerModule {
    @Binds
    fun getColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}
