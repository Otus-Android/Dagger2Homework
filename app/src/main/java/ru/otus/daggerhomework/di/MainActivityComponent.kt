package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import javax.inject.Qualifier
import javax.inject.Scope

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
@PerActivity
interface MainActivityComponent {

    @ActivityContext
    fun provideActivityContext(): Context

    @AppContext
    fun provideApplicationContext(): Context

    fun provideObserver(): MutableStateFlow<Int>

    fun provideColorGenerator(): ColorGenerator

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@ActivityContext context: Context): Builder

        fun applicationComponent(applicationComponent: ApplicationComponent): Builder

        fun build(): MainActivityComponent
    }
}

@Qualifier
annotation class ActivityContext

@Scope
annotation class PerActivity