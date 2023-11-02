package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component
interface ApplicationComponent : DaggerComponent {
    @AppContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @AppContext
            context: Context,
        ): ApplicationComponent
    }
}