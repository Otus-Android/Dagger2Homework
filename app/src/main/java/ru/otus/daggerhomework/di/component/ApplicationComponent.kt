package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

    @Named("appContext")
    fun applicationContext(): Context

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@Named("appContext") context: Context): Builder

        fun build(): ApplicationComponent
    }
}