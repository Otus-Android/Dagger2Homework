package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.di.annotations.AppContext
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }

    @AppContext
    fun context(): Context

    fun inject(app: App)

}