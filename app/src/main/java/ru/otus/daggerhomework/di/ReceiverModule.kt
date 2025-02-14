package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.ReceiverViewModel

@Module
class ReceiverModule {

    @Provides
    @FragmentScope
    fun viewModel(
        context: Context,
        event: MutableStateFlow<Event?>
    ): ReceiverViewModel = ReceiverViewModel(context, event)
}