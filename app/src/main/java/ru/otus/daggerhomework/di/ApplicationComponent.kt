package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.*
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent{
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent;
    }
}





