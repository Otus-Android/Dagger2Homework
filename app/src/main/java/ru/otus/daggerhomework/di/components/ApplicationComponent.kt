package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    // основной компонент верхнего уровня

    @Named("appContext")
    fun applicationContext(): Context

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@Named("appContext") context: Context): Builder

        fun build(): ApplicationComponent
    }

}