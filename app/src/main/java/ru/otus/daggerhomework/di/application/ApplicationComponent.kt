package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideApplicationContext(): Context

    @Component.Factory
    interface FactoryApplication {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }

}