package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}

@Module
interface FragmentProducerModule {

    @Binds
    @Named("ProducerFactory")
    fun bindsViewModelProducerFactory(
        viewModelProducerFactory: ViewModelProducerFactory
    ): ViewModelProvider.Factory
}