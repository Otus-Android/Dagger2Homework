package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@AppScope
@Component
interface ApplicationComponent {

    @get:AppContext
    val appContext: Context

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @AppContext context: Context
        ): ApplicationComponent
    }

    companion object {

        fun factory(): ApplicationComponent.Factory = DaggerApplicationComponent.factory()
    }
}

@Qualifier
annotation class AppContext
