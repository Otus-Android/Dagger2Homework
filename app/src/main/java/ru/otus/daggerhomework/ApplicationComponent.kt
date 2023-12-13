package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component
interface ApplicationComponent {
    @AppContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @AppContext
            context: Context,
        ): ApplicationComponent
    }
}
