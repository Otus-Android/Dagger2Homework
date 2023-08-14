package ru.otus.daggerhomework.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create (@BindsInstance @AppContext context: Application): ApplicationComponent
    }

    @AppContext
    fun provideAppContext(): Application
}
