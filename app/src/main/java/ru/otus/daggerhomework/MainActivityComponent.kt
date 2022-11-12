package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow

@Module
interface MainActivityModule {
    companion object {
        @JvmStatic
        @Provides
        fun providerEvent(): MutableStateFlow<AppEvent?> = MutableStateFlow(null)
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
}