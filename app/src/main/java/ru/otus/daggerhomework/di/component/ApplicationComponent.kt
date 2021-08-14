package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}