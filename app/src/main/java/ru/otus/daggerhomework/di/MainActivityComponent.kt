package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ColorEventModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @ActivityContext
            @BindsInstance
            activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorEventProducer(): MutableStateFlow<Int?>

    fun provideColorEventObserver(): StateFlow<Int?>

    fun inject(mainActivity: MainActivity)
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityContext