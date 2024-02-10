package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface ApplicationComponent {

    @AppContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class AppContext