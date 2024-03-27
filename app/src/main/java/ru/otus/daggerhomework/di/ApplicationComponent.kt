package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface ApplicationComponent {

    @AppContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@AppContext @BindsInstance context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class AppContext