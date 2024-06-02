package ru.otus.daggerhomework.di.fragments

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.LocalEvent

@Module
interface FragmentProducerModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}

@Module
object FragmentProducerChannelModule {

    @Provides
    fun provideSendChannel(impl: Channel<@JvmSuppressWildcards LocalEvent>): SendChannel<@JvmSuppressWildcards LocalEvent> {
        return impl
    }
}