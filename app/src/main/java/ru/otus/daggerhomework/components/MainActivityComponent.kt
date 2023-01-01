package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.*

@ActivityScope
@Subcomponent(modules = [MainActivitySubcomponentsModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext activityContext: Context): MainActivityComponent
    }

    fun getFragmentProducerComponentFactory(): FragmentProducerComponent.Factory

    fun getFragmentReceiverComponentFactory(): FragmentReceiverComponent.Factory
}