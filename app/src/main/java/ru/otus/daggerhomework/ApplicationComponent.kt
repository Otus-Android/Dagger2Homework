package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Scope
import javax.inject.Singleton

@Module
interface ApplicationModule {
    @Binds
    @Singleton
    @ApplicationContext
    fun bindContext(appContext: Application): Context
}

@Module(subcomponents = [MainActivityComponent::class])
interface ApplicationSubcomponentsModule

@Singleton
@Component(modules = [ApplicationModule::class, ApplicationSubcomponentsModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Application): ApplicationComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
}
