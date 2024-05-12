package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @[ApplicationContext BindsInstance]
            context: Context
        ): ApplicationComponent
    }

    @ApplicationContext
    fun provideContext(): Context
}