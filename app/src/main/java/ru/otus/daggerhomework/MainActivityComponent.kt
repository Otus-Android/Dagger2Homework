package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun getFragmentProducerComponent(): FragmentProducerComponent.Factory

    fun getFragmentReceiverComponent(): FragmentReceiverComponent.Factory
}

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface MainActivityModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun bindEventBus(eventBus: EventBusImpl): EventBus
}