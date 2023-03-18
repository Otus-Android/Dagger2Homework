package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    companion object {
        fun init(context: Context): ApplicationComponent {
            return DaggerApplicationComponent.factory()
                .create(context)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }

    fun inject(app: App)

    @AppContext
    fun provideContext(): Context
}

@Qualifier
annotation class AppContext