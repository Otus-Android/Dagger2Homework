package ru.otus.daggerhomework

import android.content.*
import dagger.*
import javax.inject.*

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class ApplicationContext