package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton

@[Component(modules = [MainActivityModule::class]) Singleton]
interface MainActivityComponent {

    fun createProducerFragmentSubComponent(): ProducerFragmentComponent

    fun createReceiverFragmentSubComponent(): ReceiverFragmentComponent

    @Component.Factory
    interface MainActivityComponentFactory {
        fun create(@BindsInstance mainActivityContext: Context): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    companion object {

        @[Provides Singleton]
        fun provideObservable(): ObservableForFragments {
            return ObservableForFragments()
        }
    }
}