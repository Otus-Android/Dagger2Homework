package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier

@Component(modules = [AppSubcomponentsModule::class])
interface ApplicationComponent {

    fun addMainActivitySubComponent(): MainActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @AppContext appContext: Context): ApplicationComponent
    }
}

@Module(subcomponents = [MainActivityComponent::class])
object AppSubcomponentsModule

@Qualifier
annotation class AppContext
