package ru.otus.daggerhomework.di.producer

import dagger.Binds
import dagger.Module
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel

/**
 * `Dagger` [Module] `Fragment`-а поставления цветов
 */
@Module
interface FragmentProducerModule {

    @Binds
    fun bindSendChannel(channel: Channel<Int>): SendChannel<Int>
}