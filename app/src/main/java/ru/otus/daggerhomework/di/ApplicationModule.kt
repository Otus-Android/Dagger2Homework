package ru.otus.daggerhomework.di

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
    fun provideApplicationContext(context: Context): Context = context
}