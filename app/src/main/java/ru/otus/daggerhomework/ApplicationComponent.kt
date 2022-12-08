package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentModule::class])
interface ApplicationComponent {

    @AppContext
    fun getApplicationContext(): Context

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory
    fun fragmentProducerComponent(): FragmentProducerComponent.Factory


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance
                   @AppContext
                   context: Context): ApplicationComponent
    }
}