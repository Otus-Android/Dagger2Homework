package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Qualifier
annotation class AppContext

@Component
interface AppComponent {

    @AppContext
    fun appContext(): Context

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @AppContext
            context: Context
        ): AppComponent
    }
}