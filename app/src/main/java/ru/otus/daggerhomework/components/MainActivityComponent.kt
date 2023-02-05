package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Scope

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {


    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance
            @Named("ActivityContext")
            appContext: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @Named("ActivityContext")
    fun provideContext(): Context
    fun addProducerComponent(): FragmentProducerComponent
    fun addReceiverComponent(): FragmentReceiverComponent
}

@Scope
annotation class MainActivityScope