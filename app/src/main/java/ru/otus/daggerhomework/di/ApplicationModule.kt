package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val applicationContext: Context) {

    @Provides
    fun provideApplicationContext(): Context {
        return applicationContext
    }

}