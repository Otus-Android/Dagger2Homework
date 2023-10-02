package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Qualifier
annotation class ApplicationContext

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): ApplicationComponent
    }
}