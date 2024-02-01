package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}