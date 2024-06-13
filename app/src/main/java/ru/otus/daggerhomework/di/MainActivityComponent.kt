package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.MainActivity

@Component(dependencies = [ApplicationComponent::class], modules = [MainModule::class])
@ActivityScope
interface MainActivityComponent {
    fun provideContext():Context

    fun provideColorGenerator(): ColorGenerator

    fun provideMutableStateFlow(): MutableStateFlow<Int>
    fun provideStateFlow(): StateFlow<Int>

    @ApplicationContext
    fun provideApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, applicationComponent: ApplicationComponent): MainActivityComponent
    }
}