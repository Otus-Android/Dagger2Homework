package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class AppContext

@Singleton
@Component(
    modules = [
        ApplicationSubComponentsModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
}

@Module(
    subcomponents = [MainActivityComponent::class]
)
interface ApplicationSubComponentsModule
