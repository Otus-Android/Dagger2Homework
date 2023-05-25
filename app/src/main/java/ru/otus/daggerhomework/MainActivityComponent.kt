package ru.otus.daggerhomework

import android.content.*
import dagger.*
import kotlinx.coroutines.flow.*
import javax.inject.*

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