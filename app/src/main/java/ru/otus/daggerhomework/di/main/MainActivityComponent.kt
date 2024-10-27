package ru.otus.daggerhomework.di.main

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.di.producer.FragmentProducerComponent
import ru.otus.daggerhomework.di.receiver.FragmentReceiverComponent
import ru.otus.daggerhomework.di.utils.qualifiers.ActivityContext
import ru.otus.daggerhomework.di.utils.scopes.ActivityScope

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class, MainActivitySubcomponentsModule::class])
interface MainActivityComponent {
    val fragmentProducerComponentFactory: FragmentProducerComponent.Factory
    val fragmentReceiverComponentFactory: FragmentReceiverComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }
}