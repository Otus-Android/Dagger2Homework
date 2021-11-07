package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ViewModelProducer

@Module
object FragmentProducerModule {

    @FragmentScope
    @Provides
    fun provideViewModelProduceFactory(context: Context, colorObserver: ColorObserver): ViewModelProvider.Factory {
        return ViewModelProviderFactory { ViewModelProducer(ColorGeneratorImpl(), context, colorObserver) }
    }
}