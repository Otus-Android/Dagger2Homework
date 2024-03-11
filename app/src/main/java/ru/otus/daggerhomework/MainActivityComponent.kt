package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Qualifier
import javax.inject.Scope

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ObserverModule::class, ColorGeneratorModule::class]
)
@ActivityScope
interface MainActivityComponent {

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
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
