package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.main.MainActivityComponent
import ru.otus.daggerhomework.di.utils.qualifiers.ApplicationContext

@Component(modules = [ApplicationSubcomponentsModule::class])
interface ApplicationComponent {
    val mainActivityComponentFactory: MainActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}