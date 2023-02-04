package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity

@ActivityScope
@Subcomponent(modules = [MainActivitySubComponentsModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun fragmentProducerComponent(): FragmentProducerComponent.Factory

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }
}

@Module(
    subcomponents = [
        FragmentProducerComponent::class,
        FragmentReceiverComponent::class
    ]
)
interface MainActivitySubComponentsModule



