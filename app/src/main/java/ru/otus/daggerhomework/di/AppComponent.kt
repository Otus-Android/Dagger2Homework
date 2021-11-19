package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.presentation.main.MainActivity
import ru.otus.daggerhomework.utils.ApplicationContext
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent : ApplicationDeps {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext applicationContext: Context): AppComponent
    }
}