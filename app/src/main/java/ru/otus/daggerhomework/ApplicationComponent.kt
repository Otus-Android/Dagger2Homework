package ru.otus.daggerhomework

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {
    fun providesApplication(): Application

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}