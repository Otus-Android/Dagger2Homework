package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

    @AppContext
    fun getAppContext(): Context

    @Component.Factory
    interface Factory {

        fun create(@[BindsInstance AppContext] context: Context): ApplicationComponent
    }

    companion object {
        fun create(@AppContext context: Context): ApplicationComponent {
            return DaggerApplicationComponent.factory().create(context)
        }
    }
}
