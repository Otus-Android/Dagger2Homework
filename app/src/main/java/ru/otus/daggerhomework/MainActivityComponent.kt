package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Scope

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    fun getEventsState(): EventsState

    @ApplicationContext
    fun getAppContext(): Context

    @ActivityContext
    fun getContext(): Context

    fun inject(activity: MainActivity)

    @Component.Factory
    interface MainActivityComponentFactory {
        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance
            @ActivityContext
            context: Context
        ): MainActivityComponent
    }
}

@Qualifier
annotation class ActivityContext

@Scope
annotation class MainActivityScope