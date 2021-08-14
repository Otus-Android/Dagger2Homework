package ru.otus.daggerhomework.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelProducer.ProducerViewModelFactory
import ru.otus.daggerhomework.di.qualifier.ProducerViewModel
import ru.otus.daggerhomework.di.scope.FragmentScope

@Module
interface FragmentProducerModule {

    companion object {
//        @FragmentScope
//        @ProducerViewModel
//        @Provides
//        fun provideColorGenerator(): ColorGenerator {
//            return ColorGeneratorImpl()
//        }

        @FragmentScope
        @ProducerViewModel
        @Provides
        fun provideViewModelProducer (colorGenerator: ColorGenerator, context: Context, sharedFlow: SharedFlow<Int>): ViewModelProducer {
            return ViewModelProducer(colorGenerator, context, sharedFlow)
        }
    }

    @FragmentScope
    @ProducerViewModel
    @Binds
    fun bindProducerViewModelFactory(producerViewModelFactory: ProducerViewModelFactory): ViewModelProvider.Factory
}