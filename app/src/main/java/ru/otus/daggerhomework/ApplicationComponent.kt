package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Qualifier
annotation class ApplicationContext

@Qualifier
annotation class ActivityContext

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ApplicationContext
            appContext: Context
        ): ApplicationComponent
    }
}