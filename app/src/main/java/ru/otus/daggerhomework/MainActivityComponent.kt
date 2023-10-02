package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ActivityScope
@Component(
    modules = [ObserverModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun provideMutableStateFlow(): MutableStateFlow<Int?>

    fun provideStateFlow(): StateFlow<Int?>

    @ApplicationContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}