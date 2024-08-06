package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @AppContext
    fun provideContext(): Context

    fun providesStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @AppContext
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}

@Module()
class ApplicationModule {
    @AppScope
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}