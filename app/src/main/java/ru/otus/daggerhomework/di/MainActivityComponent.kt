package ru.otus.daggerhomework.di

import android.app.Activity
import android.app.Application
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.Observer
import ru.otus.daggerhomework.ObserverImpl

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun provideApplication(): Application
    fun provideActivity(): Activity
    fun provideObserver(): Observer
    fun provideColorGenerator(): ColorGenerator


    @Component.Factory
    interface MainActivityComponentFactory {
        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance context: Activity
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {
    @MainActivityScope
    @Binds
    fun bindObserver(impl: ObserverImpl): Observer

    @MainActivityScope
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}