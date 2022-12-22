package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.ApplicationScope

@ApplicationScope
@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}