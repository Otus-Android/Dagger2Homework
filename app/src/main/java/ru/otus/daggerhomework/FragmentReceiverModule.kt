package ru.otus.daggerhomework

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ViewModelReceiver

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