package ru.otus.daggerhomework.activity.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
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

    fun provideColorStateFlow(): MutableStateFlow<Int?>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext activity: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}