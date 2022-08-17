package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Named

@Component
interface ApplicationComponent {

    @AppScope
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@AppScope @BindsInstance appContext: Context): ApplicationComponent
    }
}