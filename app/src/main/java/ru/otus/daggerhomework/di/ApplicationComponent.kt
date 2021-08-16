package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    val applicationContext: Context

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder

        fun build(): ApplicationComponent
    }
}