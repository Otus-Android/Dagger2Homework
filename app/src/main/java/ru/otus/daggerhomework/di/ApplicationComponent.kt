package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import javax.inject.Qualifier

@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@[BindsInstance ApplicationContext] context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class ApplicationContext

val Context.applicationComponent: ApplicationComponent
    get() = when (this) {
        is App -> this.component
        else -> this.applicationContext.applicationComponent
    }