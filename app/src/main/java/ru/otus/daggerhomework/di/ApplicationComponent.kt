package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component
interface ApplicationComponent {

    @AppContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @AppContext
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}