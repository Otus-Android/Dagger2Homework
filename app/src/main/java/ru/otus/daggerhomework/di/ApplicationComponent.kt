package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@Named("applicationContext") @BindsInstance context: Context): ApplicationComponent
    }

    @Named("applicationContext")
    fun provideContext(): Context

}