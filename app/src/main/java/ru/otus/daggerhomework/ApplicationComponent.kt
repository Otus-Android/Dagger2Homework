package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @AppName
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @AppName context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class AppName
