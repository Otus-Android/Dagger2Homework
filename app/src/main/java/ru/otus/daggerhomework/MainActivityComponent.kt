package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ProducerModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@ActivityContext @BindsInstance context: Context): MainActivityComponent
    }

    fun producerComponent(): FragmentProducerComponent.Factory
    fun receiverComponent(): FragmentReceiverComponent.Factory

    fun inject(mainActivity: MainActivity)
}

@Module(subcomponents = [MainActivityComponent::class])
interface MainActivityModule