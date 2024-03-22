package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.StateFlow

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