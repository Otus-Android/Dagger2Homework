package ru.otus.daggerhomework.di.fragments

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.LocalEvent
import ru.otus.daggerhomework.ViewModelMarkerInterface
import ru.otus.daggerhomework.ViewModelProducer2

@Module
interface FragmentProducerModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

//    @Binds
//    @IntoMap
//    @ViewModelKey(key = ViewModelProducer::class)
//    @FragmentScope
//    fun bindViewModelProducer(impl: ViewModelProducer): ViewModel

    @Binds
    @FragmentScope
    fun bindViewModelProducer2(impl: ViewModelProducer2): ViewModelMarkerInterface

}

@Module
object FragmentProducerChannelModule {

    @Provides
    @FragmentScope
    fun provideSendChannel(impl: Channel<@JvmSuppressWildcards LocalEvent>): SendChannel<@JvmSuppressWildcards LocalEvent> {
        return impl
    }
}