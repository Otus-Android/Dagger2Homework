package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Module
interface ApplicationModule {
    @Binds
    fun bindContext(appContext: Application): Context
}

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Application): ApplicationComponent
    }

    fun inject(mainActivity: MainActivity)
}