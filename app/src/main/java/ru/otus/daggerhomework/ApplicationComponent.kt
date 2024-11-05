package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier


@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory{

        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent

    }

    @AppContext
    fun provideAppContext(): Context

}

@Qualifier
annotation class AppContext