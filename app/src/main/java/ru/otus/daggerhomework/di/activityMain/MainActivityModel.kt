package ru.otus.daggerhomework.di.activityMain

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.di.annotation.Activity

@Module
object MainActivityModel {

    @Activity
    @Provides
    @JvmStatic
    fun provideApplicationContext(context: Context): Context {
        return context
    }
}
