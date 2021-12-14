package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }

    @AppContext
    fun appContext(): Context
}

@Qualifier
annotation class AppContext