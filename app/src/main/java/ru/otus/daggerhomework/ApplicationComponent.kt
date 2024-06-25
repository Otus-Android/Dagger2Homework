package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import ru.otus.daggerhomework.qualifiers.AppContext

@Singleton
@Component
interface ApplicationComponent {

    @AppContext
    fun provideApplicationContext() : Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @AppContext
            appContext : Context,
        ) : ApplicationComponent
    }
}