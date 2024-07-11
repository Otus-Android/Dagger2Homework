package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            applicationContext: Context
        ): ApplicationComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context
}

@Qualifier
annotation class ApplicationContext