package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

    fun createReceiverFragmentComponent(): ReceiverFragmentComponent

    fun createProducerFragmentComponent(): ProducerFragmentComponent

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}