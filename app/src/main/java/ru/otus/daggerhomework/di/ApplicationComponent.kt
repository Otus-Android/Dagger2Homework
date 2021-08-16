package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component()
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder

        fun build(): ApplicationComponent
    }
}