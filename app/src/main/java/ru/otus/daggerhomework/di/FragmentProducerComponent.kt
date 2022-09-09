package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.viewModel.ViewModelKey
import ru.otus.daggerhomework.viewModel.ViewModelProducer

@Subcomponent(modules = [ProducerFragmentModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

}

@Module
interface ProducerFragmentModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun bindsProducerViewModel(viewModel: ViewModelProducer): ViewModel

}