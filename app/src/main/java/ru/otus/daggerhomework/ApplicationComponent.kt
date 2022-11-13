package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @AppContext
            context: Context
        ): ApplicationComponent
    }

    @AppContext
    fun provideContext(): Context
}

@Qualifier
annotation class AppContext