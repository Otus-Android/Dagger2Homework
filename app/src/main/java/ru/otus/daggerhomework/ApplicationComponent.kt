package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component
interface ApplicationComponent {
    @ApplicationContext
    fun getAppContext(): Context

    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): ApplicationComponent
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext