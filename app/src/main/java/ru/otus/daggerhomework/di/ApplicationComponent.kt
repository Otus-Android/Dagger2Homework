package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface ApplicationComponent {

    @AppContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @AppContext applicationContext: Context): ApplicationComponent
    }
}