package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @AppContext
    fun applicationContext(): Context

    @ActivityContext
    fun activityContext(): Context

    fun provideSharedFlow(): MutableSharedFlow<Int>

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    companion object {

        lateinit var mainActivityComponentInstance: MainActivityComponent

        fun create(context: Context): MainActivityComponent {
            mainActivityComponentInstance = DaggerMainActivityComponent.factory()
                .create((context.applicationContext as App).applicationComponent, context)

            return mainActivityComponentInstance
        }
    }
}

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideSharedFlow(): MutableSharedFlow<Int> {
        return MutableSharedFlow()
    }
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityContext