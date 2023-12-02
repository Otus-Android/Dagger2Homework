package ru.otus.daggerhomework.di.fragments

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.LocalEvent
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.di.activity.ActivityContextQualifier
import ru.otus.daggerhomework.di.app.ApplicationContextQualifier

@Module
object ViewModelModule {

    @FragmentScope
    @Provides
    fun provideViewModelProducer(
        observer: Channel<LocalEvent>,
        colorGenerator: ColorGenerator,
        @ActivityContextQualifier
        activityContext: Context
    ): ViewModelProducer {
        return ViewModelProducer.Factory(observer, colorGenerator, activityContext)
            .create(ViewModelProducer::class.java)
    }

    @FragmentScope
    @Provides
    fun provideViewModelReceiver(
        observer: Channel<LocalEvent>,
        @ApplicationContextQualifier
        appContext: Context
    ): ViewModelReceiver {
        return ViewModelReceiver.Factory(observer, appContext)
            .create(ViewModelReceiver::class.java)
    }
}