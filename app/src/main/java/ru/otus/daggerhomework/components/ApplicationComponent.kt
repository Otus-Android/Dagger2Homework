package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.AppContext
import ru.otus.daggerhomework.AppModule
import ru.otus.daggerhomework.AppScope
import ru.otus.daggerhomework.AppSubcomponentsModule

@AppScope
@Component(modules = [AppSubcomponentsModule::class, AppModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @AppContext appContext: Context): ApplicationComponent
    }

    fun getMainActivityComponentFactory(): MainActivityComponent.Factory
}