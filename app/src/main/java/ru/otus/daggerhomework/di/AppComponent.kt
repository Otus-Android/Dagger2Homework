package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface AppComponent {
    @Component.Factory
    interface factory {
        fun create(@BindsInstance @AppContext context: Context): AppComponent
    }

    @AppContext
    fun applicationContext(): Context
}

@Qualifier
annotation class AppContext