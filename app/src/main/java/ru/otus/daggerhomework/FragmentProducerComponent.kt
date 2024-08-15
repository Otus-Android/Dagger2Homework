package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
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
//    @Provides
//    @Named("ProducerFactory")
//    fun provideViewModelProducer(
//        colorGenerator: ColorGenerator,
//        context: Context,
//        colorEventObserver: ColorEventObserver
//    ): ViewModelProducer {
//        return ViewModelProducer(colorGenerator, context, colorEventObserver)
//    }
}