package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.scopes.CustomSingleton
import javax.inject.Named

@Component
@CustomSingleton
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@Named("appContext") @BindsInstance context: Context): ApplicationComponent
    }

    @Named("appContext")
    fun provideContext(): Context
}