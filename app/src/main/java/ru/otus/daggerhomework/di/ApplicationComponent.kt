package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent{
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}





