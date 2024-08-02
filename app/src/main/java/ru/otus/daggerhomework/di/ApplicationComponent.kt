package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            applicationContext: Context
        ): ApplicationComponent
    }
}