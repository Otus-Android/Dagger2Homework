package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.utils.qualifiers.ApplicationContext

/**
 * `Dagger` [Component] приложения
 */
@Component
interface ApplicationComponent {

    /** `Application` контекст */
    @ApplicationContext
    fun context(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}