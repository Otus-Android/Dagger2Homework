package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.utils.AppScope
import javax.inject.Named


@AppScope
@Component()
interface ApplicationComponent {

    @Named("ApplicationContext")
    fun getApplication():Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("ApplicationContext") context: Context): ApplicationComponent
    }
}
