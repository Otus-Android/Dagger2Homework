package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent(modules = [ProducerBindsModule::class])
@Singleton
interface FragmentProducerComponent {

    fun injectToFragmentProducer(fragmentProducer: FragmentProducer)

}

@Module
interface ProducerBindsModule {

    @Binds
    fun viewModelProducer(viewModelProducer: ViewModelProducer): IViewModelProducer

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}