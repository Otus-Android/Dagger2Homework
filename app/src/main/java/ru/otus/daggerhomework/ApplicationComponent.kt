package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.qualifier.AppContext
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface ContextFactory {
        fun create(@BindsInstance @AppContext context: Context) : ApplicationComponent
    }

    companion object {
        fun getAppComponent(context: Context) : ApplicationComponent =
            DaggerApplicationComponent.factory().create(context)
    }

    @AppContext
    fun provideAppContext(): Context
}