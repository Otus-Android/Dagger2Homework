package ru.otus.daggerhomework.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun mainActivityComponent(): MainActivityComponent.Factory

    @Component.Factory
    interface Builder {
        fun build(@BindsInstance application: Application): ApplicationComponent
    }
}