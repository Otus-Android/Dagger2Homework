package ru.otus.daggerhomework.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Named("app")
    fun provideContext(): Context

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @Named("app") context: Context): ApplicationComponent
    }
}
