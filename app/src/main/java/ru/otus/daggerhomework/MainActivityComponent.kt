package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @ActivityContextQualifier
    fun provideActivityContext(): Context

    fun provideColorStateFlow(): MutableStateFlow<Color>

    @Component.Factory
    interface MainActivityComponentFactory {

        fun create(
            @BindsInstance
            @ActivityContextQualifier
            activityContext: Context,
            mainActivityComponent: ApplicationComponent
        ): MainActivityComponent
    }
}