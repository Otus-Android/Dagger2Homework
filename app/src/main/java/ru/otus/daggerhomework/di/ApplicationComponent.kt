package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

@ActivityScope
@Component(
    modules = [ColorPipelineModule::class]
)
interface ApplicationComponent {

    fun createMainActivityComponentFactory(): MainActivityComponent.MainActivityComponentFactory

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Qualifier
@Singleton
annotation class ApplicationContext

@Scope
annotation class ActivityScope