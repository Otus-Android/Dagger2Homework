package ru.otus.daggerhomework.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.ViewModelReceiver.ReceiverViewModelFactory
import ru.otus.daggerhomework.di.qualifier.ReceiverViewModel
import ru.otus.daggerhomework.di.scope.FragmentScope

@Module
interface FragmentReceiverModule {

    companion object {
        @FragmentScope
        @ReceiverViewModel
        @Provides
        fun provideViewModelReceiver(context: Context, sharedFlow: SharedFlow<Int>): ViewModelReceiver {
            return ViewModelReceiver(context, sharedFlow)
        }
    }

    @FragmentScope
    @ReceiverViewModel
    @Binds
    fun bindReceiverViewModelFactory(receiverViewModelFactory: ReceiverViewModelFactory): ViewModelProvider.Factory

//    @Module
//    class FragmentReceiverModuleFlow{
//        @FragmentScope
//        @ReceiverViewModel
//        @Provides
//        fun provideViewModelReceiver(context: Context, sharedFlow: SharedFlow<Int>): ViewModelReceiver{
//            return ViewModelReceiver(context, sharedFlow)
//        }
//    }
}