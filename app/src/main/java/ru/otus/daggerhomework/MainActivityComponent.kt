package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import jakarta.inject.Singleton
import ru.otus.daggerhomework.quilifiers.MainActivityContext

@[Subcomponent(modules = [MainActivityModule::class]) Singleton]
interface MainActivityComponent {

    fun createProducerFragmentSubComponent(): ProducerFragmentComponent

    fun createReceiverFragmentSubComponent(): ReceiverFragmentComponent

    @Subcomponent.Factory
    interface MainActivityComponentFactory {
        fun create(@BindsInstance @MainActivityContext mainActivityContext: Context): MainActivityComponent
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