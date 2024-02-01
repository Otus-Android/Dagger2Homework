package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.EventBus

@MainScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [EventBusModule::class]
)
interface MainActivityComponent {

    @ActivityContext
    fun getContext(): Context

    @ApplicationContext
    fun getAppContext(): Context

    fun getEventBus(): EventBus

    @Component.Factory
    interface MainActivityComponentFactory {

        fun create(
            @BindsInstance
            @ActivityContext
            context: Context,
            appComponent: ApplicationComponent,
        ): MainActivityComponent
    }
}