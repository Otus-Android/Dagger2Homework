package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.MainActivity
import javax.inject.Qualifier

@ActivityScope
@Component(
    modules = [ColorObserverModule::class],
    dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

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

    fun provideMutableObserver(): MutableStateFlow<Int?>

    fun provideImmutableObserver(): StateFlow<Int?>

    fun inject(mainActivity: MainActivity)

}

@Qualifier
annotation class ActivityContext