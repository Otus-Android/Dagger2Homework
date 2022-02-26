package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @ApplicationContext
            application: Context
        ): ApplicationComponent
    }

    @ApplicationContext
    fun provideContext(): Context
}