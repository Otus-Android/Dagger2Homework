package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.BindsMainModule
import ru.otus.daggerhomework.StateObserver
import javax.inject.Singleton

@Singleton
@ActivityScope
@Component(modules = [BindsMainModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun getComponent(
            @BindsInstance @ActivityContext context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    fun getStateFlow(): StateObserver

    @ApplicationContext
    fun getApplicationContext(): Context

    @ActivityContext
    fun getContext(): Context
}
