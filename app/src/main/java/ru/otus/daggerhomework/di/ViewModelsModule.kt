package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver


@Module(includes = [ToolsModule::class, EventSourceModule::class])
object ViewModelsModule {

    @ActivityScope
    @Provides
    fun getProducerViewModule(
        colorGenerator: ColorGenerator,
        source: MutableSharedFlow<Event>
    ) = ViewModelProducer(
        colorGenerator,
        source
    )

    @ActivityScope
    @Provides
    fun getReceiverViewModule(
        source: MutableSharedFlow<Event>
    ) = ViewModelReceiver(
        source
    )

}