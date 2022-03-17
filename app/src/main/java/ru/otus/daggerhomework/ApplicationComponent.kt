package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class ApplicationContext

@Singleton
@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext applicationContext: Context): ApplicationComponent
    }
}