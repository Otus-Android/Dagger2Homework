package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Named("appContext")
    fun provideContext(): Context

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance @Named("appContext") context: Context): ApplicationComponent
    }

}