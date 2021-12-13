package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

const val APPLICATION_CONTEXT = "applicationContext"

@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @Named(APPLICATION_CONTEXT)
            @BindsInstance context: Context
        ): ApplicationComponent
    }

    @Named(APPLICATION_CONTEXT)
    fun provideContext(): Context
}
