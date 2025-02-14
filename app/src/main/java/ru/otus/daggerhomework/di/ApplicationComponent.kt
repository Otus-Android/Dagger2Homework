package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance context: Context): ApplicationComponent
    }
}