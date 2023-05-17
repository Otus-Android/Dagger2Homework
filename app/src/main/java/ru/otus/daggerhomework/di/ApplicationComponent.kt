package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.Constants.APP_CONTEXT
import javax.inject.Named

@AppScope
@Component
interface ApplicationComponent {

    companion object {
        fun getApplicationComponent(context: Context) =
            DaggerApplicationComponent.factory().create(context)
    }
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named(APP_CONTEXT) context: Context): ApplicationComponent
    }

    @Named(APP_CONTEXT)
    fun provideContext(): Context
}
