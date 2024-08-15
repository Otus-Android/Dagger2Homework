package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}

@Module
interface FragmentReceiverModule {

//    @Provides
//    @Named("ReceiverFactory")
//    fun bindsViewModelReceiver(
//        context: Context,
//        colorEventObserver: ColorEventObserver
//    ): ViewModelReceiver {
//        return ViewModelReceiver(context, colorEventObserver)
//    }

}