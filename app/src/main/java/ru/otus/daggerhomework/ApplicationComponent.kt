package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @AppContext appContext: Context
        ): ApplicationComponent
    }

    @AppContext
    fun provideAppContext(): Context
}