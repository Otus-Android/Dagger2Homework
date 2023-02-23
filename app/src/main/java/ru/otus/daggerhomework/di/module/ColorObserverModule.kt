package ru.otus.daggerhomework.di.module

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorProducer
import ru.otus.daggerhomework.ColorReceiver

@Module
interface ColorObserverModule {

    @Binds
    fun bindColorReceiver(colorObserver: ColorObserver): ColorReceiver

    @Binds
    fun bindColorProducer(colorObserver: ColorObserver): ColorProducer
}