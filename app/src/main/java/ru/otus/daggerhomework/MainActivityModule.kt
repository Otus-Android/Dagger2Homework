package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {

    @Binds
    @ClassKey(ViewModelProducer::class)
    @IntoMap
    @ActivityScope
    fun provideViewModelProducer(viewModel: ViewModelProducer): ViewModel

    @Binds
    @ClassKey(ViewModelReceiver::class)
    @IntoMap
    @ActivityScope
    fun provideViewModelReceiver(viewModel: ViewModelReceiver): ViewModel

    @Binds
    @ActivityScope
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @Binds
    @ActivityScope
    fun bindEventWriter(eventsWriter: EventsWriterReader): EventsWriter

    @Binds
    @ActivityScope
    fun bindEventReader(eventsReader: EventsWriterReader): EventsReader

    companion object{


        @Provides
        @ActivityScope
        fun provideEventsReaderWriter() = EventsWriterReader()

    }
}