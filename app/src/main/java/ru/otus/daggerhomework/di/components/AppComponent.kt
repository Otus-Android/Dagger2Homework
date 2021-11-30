package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.dependencies.MainActivityDependencies
import ru.otus.daggerhomework.utils.ApplicationContext
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent : MainActivityDependencies {

    @Component.Factory
    interface Factory {
        fun create(@[BindsInstance ApplicationContext] applicationContext: Context): AppComponent
    }
}