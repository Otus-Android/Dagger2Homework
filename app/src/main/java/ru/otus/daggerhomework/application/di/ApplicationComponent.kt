package ru.otus.daggerhomework.application.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ApplicationContext context: Context
        ): ApplicationComponent
    }
}

