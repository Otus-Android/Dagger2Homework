package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    @ApplicationContextQualifier
    fun provideApplicationContext(): Context

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @ApplicationContextQualifier
            @BindsInstance
            applicationContext: Context
        ): ApplicationComponent
    }
}