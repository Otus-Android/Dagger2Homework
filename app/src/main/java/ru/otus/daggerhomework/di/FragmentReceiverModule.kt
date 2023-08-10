package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.di.qualifier.AppContext

@Module
object FragmentReceiverModule {

    @Provides
    fun provideViewModelReceiver(
        @AppContext context: Context,
        colorStateFlow: StateFlow<Int?>
    ): ViewModelReceiver {
        return ViewModelReceiver(context, colorStateFlow)
    }
}