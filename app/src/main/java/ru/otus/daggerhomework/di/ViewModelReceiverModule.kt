package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import ru.otus.daggerhomework.ColorNumber
import ru.otus.daggerhomework.ViewModelReceiver

@Module
object ViewModelReceiverModule {
    @Provides
    @FragmentScope
    fun provideViewModelReceiverFactory(
        @Subscriber subscriber: Flow<ColorNumber>,
        @ApplicationContext context: Context
    ): ViewModelProvider.Factory = ViewModelReceiver.factory(subscriber, context)
}