package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {
    @AppContext
    fun providesAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun providesStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}