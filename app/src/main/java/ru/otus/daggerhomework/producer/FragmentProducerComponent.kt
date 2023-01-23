package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ProducerBindsModule::class])
interface FragmentProducerComponent {

    fun injectToFragmentProducer(fragmentProducer: FragmentProducer)

}

@Module
interface ProducerBindsModule {

    @Binds
    @Singleton
    fun viewModelProducer(viewModelProducer: ViewModelProducer): IViewModelProducer

    @Binds
    @Singleton
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}