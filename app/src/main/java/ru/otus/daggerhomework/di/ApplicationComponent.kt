package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

    @Named("appContext")
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("appContext") context: Context): ApplicationComponent
    }
}
