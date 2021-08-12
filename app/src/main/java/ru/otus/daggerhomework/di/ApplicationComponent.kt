package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    AppModule::class,
    MainActivityModule::class,
    FragmentProducerModule::class,
    FragmentReceiverModule::class,
    FragmentProducerModuleProv::class
])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
    fun fragmentProducerComponent(): FragmentProducerComponent.Factory
    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory
}