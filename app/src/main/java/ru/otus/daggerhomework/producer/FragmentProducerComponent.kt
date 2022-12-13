package ru.otus.daggerhomework.producer

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.applicaion.ViewModelApi
import ru.otus.daggerhomework.applicaion.ViewModelKey
import javax.inject.Scope

@Subcomponent(modules = [ProducerModule::class, ProducerBindsModule::class])
@ProducerScope
interface FragmentProducerComponent : ViewModelApi

@Scope
@Retention
annotation class ProducerScope


@Module
internal interface ProducerModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun viewModelProducer(viewModelProducer: ViewModelProducer): ViewModel

}

@Module
interface ProducerBindsModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}