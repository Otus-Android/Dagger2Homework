package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import ru.otus.daggerhomework.observer.ColorGenerationStateEmitter
import ru.otus.daggerhomework.observer.ColorGenerationStateFlow
import ru.otus.daggerhomework.observer.ColorGenerationStateObserver
import ru.otus.daggerhomework.screens.main.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorStateEmitter(): ColorGenerationStateEmitter

    fun provideColorStateObserver(): ColorGenerationStateObserver

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance
            @ActivityContext context: Context
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    @ActivityScope
    @Binds
    fun provideColorStateEmitter(
        stateFlow: ColorGenerationStateFlow
    ): ColorGenerationStateEmitter

    @ActivityScope
    @Binds
    fun provideColorStateObserver(
        stateFlow: ColorGenerationStateFlow
    ): ColorGenerationStateObserver
}

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope