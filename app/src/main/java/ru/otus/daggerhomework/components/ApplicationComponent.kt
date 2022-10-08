package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @ApplicationContext fun provideContext():Context

    @Component.Factory
    interface Factory {
        fun add(@BindsInstance @ApplicationContext context: Context) : ApplicationComponent
    }
}