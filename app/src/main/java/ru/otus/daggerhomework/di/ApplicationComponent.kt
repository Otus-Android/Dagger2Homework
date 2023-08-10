package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.qualifier.AppContext
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