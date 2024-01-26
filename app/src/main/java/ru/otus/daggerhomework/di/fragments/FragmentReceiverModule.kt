package ru.otus.daggerhomework.di.fragments

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import ru.otus.daggerhomework.LocalEvent

@Module
object FragmentReceiverChannelModule {

    @Provides
    fun provideReceiveChannel(impl: Channel<@JvmSuppressWildcards LocalEvent>): ReceiveChannel<@JvmSuppressWildcards LocalEvent> {
        return impl
    }
}
