package ru.otus.daggerhomework.applicaion

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            @Named("ApplicationContext")
            context: Context
        ): ApplicationComponent
    }

    @Named("ApplicationContext")
    fun getApplicationContext(): Context

}

