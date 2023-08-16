package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ActivityScope
@Component (modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create (
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context

    @AppContext
    fun provideAppContext(): Context

    fun provideStateFlow(): StateFlow<Int>

    fun provideMutableStateFlow(): MutableStateFlow<Int>
}


@Module
interface MainActivityModule {

    companion object {

        @Provides
        @ActivityScope
        fun provideMutableStateFlow() = MutableStateFlow(-15685544)
    }

    @Binds
    fun bindStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>

}
