package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @AppContext
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class AppContext