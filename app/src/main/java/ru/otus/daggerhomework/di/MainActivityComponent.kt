package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.presentation.MainActivity

@ActivityScope
@Subcomponent(modules = [FragmentsModule::class])
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