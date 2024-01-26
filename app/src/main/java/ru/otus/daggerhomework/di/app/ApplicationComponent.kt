package ru.otus.daggerhomework.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @ApplicationContextQualifier
    fun provideAppContext(): Context

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            @ApplicationContextQualifier
            context: Context
        ): ApplicationComponent
    }
}