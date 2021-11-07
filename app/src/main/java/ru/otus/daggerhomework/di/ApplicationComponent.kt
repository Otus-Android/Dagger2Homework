package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@ApplicationContext @BindsInstance applicationContext: Context): ApplicationComponent
    }

    @ApplicationContext
    fun applicationContext(): Context
}