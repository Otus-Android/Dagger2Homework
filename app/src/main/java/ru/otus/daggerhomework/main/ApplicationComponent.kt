package ru.otus.daggerhomework.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @AppContext appContext: Context,
        ): ApplicationComponent
    }

    @AppContext
    fun appContext(): Context
}

@Module
interface ApplicationModule

@Qualifier
annotation class AppContext

@Qualifier
annotation class ActivityContext