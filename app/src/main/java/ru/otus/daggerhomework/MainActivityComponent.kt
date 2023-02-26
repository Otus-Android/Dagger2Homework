package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope

@ActivityScope
@Component(
    modules = [ObserveModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun provideFlow(): MutableStateFlow<Int?>

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