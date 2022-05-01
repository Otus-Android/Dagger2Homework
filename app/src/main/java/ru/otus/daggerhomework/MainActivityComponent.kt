package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Scope

@Scope
annotation class ActivityScope

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideActivityContext(): Context

    fun provideStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}