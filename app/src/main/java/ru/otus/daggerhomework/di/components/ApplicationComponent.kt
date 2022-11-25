package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.qualifiers.AppContext
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @AppContext
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
       fun create(
           @BindsInstance @AppContext context: Context
       ): ApplicationComponent
    }

}