package ru.otus.daggerhomework.di.receiver

import dagger.Binds
import dagger.Module
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

@Module
interface FragmentReceiverModule {
    @Binds
    fun bindReceiveChannel(channel: Channel<Int>): ReceiveChannel<Int>
}