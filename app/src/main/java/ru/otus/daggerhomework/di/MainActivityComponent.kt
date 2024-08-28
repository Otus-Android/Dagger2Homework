package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {
    @AppContext
    fun providesAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun providesStateFlow(): MutableStateFlow<Int>

    fun flow(): Flow<Int>

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
    fun bindFlow(flow: MutableStateFlow<Int>): Flow<Int>

    companion object {
        @ActivityScope
        @Provides
        fun mutableStateFlow(): MutableStateFlow<Int> = MutableStateFlow(0)
    }
}