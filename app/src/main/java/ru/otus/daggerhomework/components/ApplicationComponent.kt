package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

const val APPLICATION_CONTEXT = "applicationContext"

@Component
interface ApplicationComponent {

    @Named(APPLICATION_CONTEXT)
    fun getAppContext() : Context

    @Component.Factory
    interface AppCompFactory {
        fun create(@Named(APPLICATION_CONTEXT) @BindsInstance context: Context): ApplicationComponent
    }
}