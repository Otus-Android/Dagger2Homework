package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)

    fun getViewModelProducerFactory(): ViewModelProducer.Factory
}