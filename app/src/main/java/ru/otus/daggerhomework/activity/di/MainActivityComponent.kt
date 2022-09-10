package ru.otus.daggerhomework.activity.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ActivityScope
import ru.otus.daggerhomework.application.di.ApplicationComponent
import ru.otus.daggerhomework.application.di.ApplicationContext

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @ActivityContext
    fun provideActivityContext(): Context
    @ApplicationContext
    fun provideApplicationContext(): Context
    @ColorState
    fun provideColorStateFlow(): StateFlow<Int?>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext activity: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}