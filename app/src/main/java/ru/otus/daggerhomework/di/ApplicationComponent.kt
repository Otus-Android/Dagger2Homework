package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface ApplicationComponent {
    @ApplicationContext
    fun getContext(): Context

    @Component.Factory
    interface Factory {
        fun getComponent(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Qualifier
@Retention annotation class ApplicationContext

@Qualifier @Retention annotation class ActivityContext
