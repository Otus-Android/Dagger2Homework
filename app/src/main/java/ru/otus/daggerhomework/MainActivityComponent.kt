package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Qualifier

@ActivityColorScope
@Component(
    modules = [ColorObserverModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    companion object{
        fun getMainActivityComponent(@ActivityContext activityContext: Context, appComponent: ApplicationComponent): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(
                activityContext,
                appComponent
            )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideMutableStateFlow(): MutableStateFlow<Int>

    fun provideStateFlow(): StateFlow<Int>
}

@Qualifier
annotation class ActivityContext
