package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Qualifier

@Component
interface ApplicationComponent {
    @ApplicationContext
    fun provideContext(): Context
    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @ApplicationContext
            @BindsInstance applicationContext: Context
        ): ApplicationComponent
    }
}

@Qualifier
annotation class ApplicationContext