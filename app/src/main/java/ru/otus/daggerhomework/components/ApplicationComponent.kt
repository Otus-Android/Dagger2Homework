package ru.otus.daggerhomework.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    fun getFragmentReceiverComponent() : FragmentReceiverComponent
    fun getFragmentProducerComponent() : FragmentProducerComponent
    fun getApplication(): Application

    @Component.Factory
    interface AppCompFactory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}