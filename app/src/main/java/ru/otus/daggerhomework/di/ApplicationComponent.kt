package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @AppQualifier
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@AppQualifier @BindsInstance appContext: Context): ApplicationComponent
    }
}