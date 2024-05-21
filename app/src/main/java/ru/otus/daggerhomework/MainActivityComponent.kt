package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @[ActivityContext BindsInstance] context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideContext(): Context

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideColorObserver(): ColorObserver
}


@Module
interface MainActivityModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @ActivityScope
    @Binds
    fun bindColorObserver(colorObserverImpl: ColorObserverImpl): ColorObserver
}