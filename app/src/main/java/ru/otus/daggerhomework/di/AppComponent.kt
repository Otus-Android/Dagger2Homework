package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            applicationContext: Context
        ): AppComponent
    }

    val activityComponent: ActivityComponent.Factory
}

@Qualifier
annotation class ApplicationContext