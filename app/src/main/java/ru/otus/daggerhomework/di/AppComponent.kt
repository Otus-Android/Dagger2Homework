package ru.otus.daggerhomework.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent : AppProvider {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}

interface AppProvider {
    fun provideApplication(): Application
}