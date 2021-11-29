package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @AppContext
    fun provideApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @AppContext
            @BindsInstance context: Context
        ): ApplicationComponent
    }

}
