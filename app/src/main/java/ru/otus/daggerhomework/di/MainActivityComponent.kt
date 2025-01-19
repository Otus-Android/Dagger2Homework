package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Qualifier

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideStateFlow(): StateFlow<Int>

    fun provideMutableStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    @Binds
    fun bindStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>

    companion object {
        @ActivityScope
        @Provides
        fun provideMutableStateFlow() = MutableStateFlow(0)
    }
}

@Qualifier
annotation class ActivityContext