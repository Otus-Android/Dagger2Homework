package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Scope

@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    fun getEventObserver(): EventObserver

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

@Module
interface MainActivityModule {
    @Binds
    @MainActivityScope
    fun bindsEventObserver(eventObserverImpl: EventObserverImpl): EventObserver
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainActivityScope