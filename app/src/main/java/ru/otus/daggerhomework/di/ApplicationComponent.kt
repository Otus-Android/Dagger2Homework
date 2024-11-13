package ru.otus.daggerhomework.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface ApplicationComponent {

    fun provideApplication():Application

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context: Application): ApplicationComponent
    }
}