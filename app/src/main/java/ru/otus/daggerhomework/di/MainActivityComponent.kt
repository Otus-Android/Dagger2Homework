package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.StateContainer
import ru.otus.daggerhomework.StateContainerImpl
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

    fun provideStateContainer(): StateContainer

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
    @ActivityScope
    fun bindStateContainer(stateContainerImpl: StateContainerImpl): StateContainer
}

@Qualifier
annotation class ActivityContext