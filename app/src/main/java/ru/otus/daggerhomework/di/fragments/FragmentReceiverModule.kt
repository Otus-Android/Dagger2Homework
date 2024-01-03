package ru.otus.daggerhomework.di.fragments

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import ru.otus.daggerhomework.LocalEvent
import ru.otus.daggerhomework.ViewModelMarkerInterface
import ru.otus.daggerhomework.ViewModelReceiver2

@Module
interface FragmentReceiverModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(key = ViewModelReceiver::class)
//    @FragmentScope
//    fun bindViewModelReceiver(impl: ViewModelReceiver): ViewModel

    @Binds
    @FragmentScope
    fun bindViewModelReceiver2(impl: ViewModelReceiver2): ViewModelMarkerInterface
}

@Module
object FragmentReceiverChannelModule {

    @Provides
    @FragmentScope
    fun provideReceiveChannel(impl: Channel<@JvmSuppressWildcards LocalEvent>): ReceiveChannel<@JvmSuppressWildcards LocalEvent> {
        return impl
    }
}
