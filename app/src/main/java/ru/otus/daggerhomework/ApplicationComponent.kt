package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface ApplicationComponent {

    @ApplicationContext
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): ApplicationComponent
    }

}