package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Scope


@AppScope
@Component()
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@AppContext @BindsInstance context: Context): ApplicationComponent
    }

    @AppContext
    fun provideAppContext(): Context
}

@Qualifier
annotation class AppContext

@Scope
annotation class AppScope