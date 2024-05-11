package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@ApplicationContext @BindsInstance context: Context): ApplicationComponent
    }
}
