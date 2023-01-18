package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activityContext: Context) {

    @Provides
    fun getActivityContext(): Context {
        return activityContext
    }

}