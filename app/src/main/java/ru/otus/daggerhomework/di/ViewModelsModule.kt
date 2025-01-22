package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Named


@Module(includes = [ToolsModule::class])
object ViewModelsModule {

    @Provides
    fun getProducerViewModule(
        colorGenerator: ColorGenerator,
        @Named("ActivityContext")
        context: Context
    ) = ViewModelProducer(
        colorGenerator,
        context
    )

    @Provides
    fun getReceiverViewModule(
        @Named("ActivityContext")
        context: Context
    ) = ViewModelReceiver(
        context
    )

}