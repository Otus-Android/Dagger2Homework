package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import ru.otus.daggerhomework.Color
import ru.otus.daggerhomework.ViewModelReceiver

@Module
object ViewModelReceiverModule {
    @Provides
    fun provideViewModelReceiverFactory(
        subscriber: Flow<Color>,
        @ApplicationContext context: Context
    ): ViewModelProvider.Factory = ViewModelReceiver.factory(subscriber, context)
}