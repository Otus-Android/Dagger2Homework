package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducerComponent
import ru.otus.daggerhomework.FragmentReceiverComponent

@ActivityScope
@Subcomponent(modules = [MainActivitySubcomponents::class, ColorGeneratorModule::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@ActivityContext @BindsInstance context: Context): MainActivityComponent
    }

    fun fragmentProducerComponent(): FragmentProducerComponent.Factory
    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory
}