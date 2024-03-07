package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideApplication(): Context

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class ApplicationContext