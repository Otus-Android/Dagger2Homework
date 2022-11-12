package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

@Module
interface MainActivityModule {
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun providerEvent(): MutableSharedFlow<AppEvent> = MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)
    }
}

@Module(subcomponents = [FragmentReceiverComponent::class, FragmentProducerComponent::class])
interface MainActivitySubcomponentsModule

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class, MainActivitySubcomponentsModule::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun fragmentProducerComponent(): FragmentProducerComponent
    fun fragmentReceiverComponent(): FragmentReceiverComponent
}