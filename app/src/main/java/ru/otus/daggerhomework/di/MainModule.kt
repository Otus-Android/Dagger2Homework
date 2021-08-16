package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
class MainModule {

    @Provides
    @MainScope
    fun provideObserver(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }

    @Provides
    @ActivityContext
    fun provideActivityContext(activity: Activity): Context {
        return activity
    }

}