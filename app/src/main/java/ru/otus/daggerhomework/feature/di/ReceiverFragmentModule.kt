package ru.otus.daggerhomework.feature.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.qualifier.AppContext
import ru.otus.daggerhomework.feature.viewmodels.ReceiverViewModel

@Module
object ReceiverFragmentModule {

    @Provides
    fun createReceiverViewModel(
        @AppContext context: Context,
        stateColor: StateFlow<Int?>,
    ) =
        ReceiverViewModel(context, stateColor)
}