package ru.otus.daggerhomework.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }

    fun getApplicationContext(): Application
}

@Module
interface AppModule {
    fun getApplicationContext(): Application
}