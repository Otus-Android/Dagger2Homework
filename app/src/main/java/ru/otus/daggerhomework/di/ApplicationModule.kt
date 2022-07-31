package ru.otus.daggerhomework.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(subcomponents = [MainActivityComponent::class])
class ApplicationModule {
    @Singleton
    @Provides
    @Named("ApplicationContext")
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext
}