package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.qualifiers.ViewModelKey

@Module
interface ProducerModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl) : ColorGenerator

    @Binds
    @[IntoMap ViewModelKey(ViewModelProducer::class)]
    fun provideViewModelProducer(viewModel: ViewModelProducer): ViewModel
}
