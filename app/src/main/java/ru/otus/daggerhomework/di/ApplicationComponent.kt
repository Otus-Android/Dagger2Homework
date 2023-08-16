package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create (@BindsInstance @AppContext context: Context): ApplicationComponent
    }

    @AppContext
    fun provideAppContext(): Context
}
