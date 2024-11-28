package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Scope

@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {
    @Component.Factory
    interface MainActivityComponentFactory {
        fun create(@BindsInstance context : Context) : MainActivityComponent
    }

    fun inject(activity : MainActivity)
}

@Module
interface MainActivityModule {
}
