package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ViewModelReceiver

@Module
object FragmentReceiverModule {

    @FragmentScope
    @Provides
    fun provideViewModelReceiver(@AppContext context: Context, colorObserver: ColorObserver): ViewModelProvider.Factory {
        return ViewModelProviderFactory { ViewModelReceiver(context, colorObserver) }
    }
}
